package org.openmrs.module.flowsheet.definition.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openmrs.Concept;
import org.openmrs.PatientProgram;
import org.openmrs.module.flowsheet.api.QuestionType;
import org.openmrs.module.flowsheet.api.models.Flowsheet;
import org.openmrs.module.flowsheet.api.models.Milestone;
import org.openmrs.module.flowsheet.definition.HandlerProvider;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class FlowsheetDefinitionTest {

    @Mock
    Concept systolic;

    @Mock
    Concept diastolic;

    @Mock
    HandlerProvider handlerProvider;


    @InjectMocks
    MilestoneDefinition milestoneDefinition;

    private FlowsheetDefinition flowsheetDefinition;
    private SimpleDateFormat simpleDateFormat;

    @Before
    public void setup() throws ParseException {
        initMocks(this);
        QuestionDefinition questionDefinition = new QuestionDefinition("Blood Pressure", new LinkedHashSet<>(Arrays.asList(systolic, diastolic)), QuestionType.OBS);

        Map<String, String> config = new HashMap<>();
        config.put("min", "0");
        config.put("max", "30");

        milestoneDefinition.setName("M1");
        milestoneDefinition.setConfig(config);
        milestoneDefinition.setQuestionDefinitions(new LinkedHashSet<>(Arrays.asList(questionDefinition)));

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2016-10-10");
        Set<MilestoneDefinition> milestoneDefinitions = new LinkedHashSet<>();
        milestoneDefinitions.add(milestoneDefinition);
        Set<QuestionDefinition> questionDefinitions = new LinkedHashSet<>();
        questionDefinitions.add(questionDefinition);

        flowsheetDefinition = new FlowsheetDefinition(date, milestoneDefinitions);
    }

    @Test
    public void shouldCreateFlowsheetFromDefinition() throws ParseException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Flowsheet flowsheet = flowsheetDefinition.createFlowsheet(new PatientProgram());
        Date date = simpleDateFormat.parse("2016-10-10");
        Set<Milestone> milestones = flowsheet.getMilestones();

        assertEquals(date, flowsheet.getStartDate());
        assertEquals(1, milestones.size());
    }

}