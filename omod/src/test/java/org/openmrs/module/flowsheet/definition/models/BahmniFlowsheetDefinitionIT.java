package org.openmrs.module.flowsheet.definition.models;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openmrs.Concept;
import org.openmrs.PatientProgram;
import org.openmrs.api.ConceptService;
import org.openmrs.api.ProgramWorkflowService;
import org.openmrs.api.context.Context;
import org.openmrs.module.flowsheet.api.QuestionType;
import org.openmrs.module.flowsheet.api.models.Flowsheet;
import org.openmrs.module.flowsheet.api.models.Milestone;
import org.openmrs.module.flowsheet.api.models.QuestionEvaluatorFactory;
import org.openmrs.module.flowsheet.definition.HandlerProvider;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.DRUG_BDQ;
import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.DRUG_DELAMANID;
import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.TREATMENT_END_DATE_HANDLER;

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.test.context.ContextConfiguration(locations = {"classpath:TestingApplicationContext.xml"}, inheritLocations = true)
public class BahmniFlowsheetDefinitionIT extends BaseModuleContextSensitiveTest {

    public static final String systolic = "Systolic";
    public static final String diastolic = "Diastolic";


    private ConceptService conceptService;

    private ProgramWorkflowService programWorkflowService;

    private MilestoneDefinition baselineMonth;

    private MilestoneDefinition endOfTreatmentMonth;



    @Autowired
    HandlerProvider handlerProvider;

    @Autowired
    QuestionEvaluatorFactory questionEvaluatorFactory;


    @Before
    public void setUp() throws Exception {
        executeDataSet("patientProgramTestData.xml");
        executeDataSet("src/test/resources/flowsheetTestData.xml");
        conceptService = Context.getConceptService();
        programWorkflowService = Context.getProgramWorkflowService();
    }


    @Test
    public void shouldEvaluateFlowsheetAndSetResults() throws ParseException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Concept delamanid = conceptService.getConceptByName(DRUG_DELAMANID);
        Concept bdq = conceptService.getConceptByName(DRUG_BDQ);

        Concept systolicConcept = conceptService.getConceptByName(systolic);
        Concept diastolicConcept = conceptService.getConceptByName(diastolic);
        QuestionDefinition q1 = new QuestionDefinition("New Drugs", new LinkedHashSet<>(Arrays.asList(delamanid, bdq)), QuestionType.DRUG);
        QuestionDefinition q2 = new QuestionDefinition("Blood Pressure", new LinkedHashSet<>(Arrays.asList(systolicConcept, diastolicConcept)), QuestionType.OBS);

        Map<String, String> config = new HashMap<>();
        config.put("min", "0");
        config.put("max", "30");

        baselineMonth = new MilestoneDefinition("M1", config, null, handlerProvider);
        baselineMonth.setQuestionDefinitions(new LinkedHashSet<>(Arrays.asList(q2)));

        Map<String, String> endOfTreatmentConfig = new HashMap<>();
        endOfTreatmentConfig.put("min", "-15");
        endOfTreatmentConfig.put("max", "15");


        endOfTreatmentMonth = new MilestoneDefinition("MTx", endOfTreatmentConfig, TREATMENT_END_DATE_HANDLER, handlerProvider);
        endOfTreatmentMonth.setQuestionDefinitions(new LinkedHashSet<>(Arrays.asList(q1)));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date flowsheetStartDate = simpleDateFormat.parse("2016-10-10");

        FlowsheetDefinition flowsheetDefinition = new FlowsheetDefinition(flowsheetStartDate, new LinkedHashSet<>(Arrays.asList(baselineMonth, endOfTreatmentMonth)));


        PatientProgram patientProgram = programWorkflowService.getPatientProgram(100);
        Flowsheet flowsheet = flowsheetDefinition.createFlowsheet(patientProgram);
        questionEvaluatorFactory.init(patientProgram, flowsheet.getObsFlowsheetConcepts());
        flowsheet.evaluate(questionEvaluatorFactory);

        ArrayList<Milestone> milestoneArrayList = new ArrayList<>();
        for (Milestone milestone : flowsheet.getMilestones()) {
            milestoneArrayList.add(milestone);
        }


        assertNotNull(milestoneArrayList.get(0).getQuestions());
        assertEquals(2, milestoneArrayList.size());
        assertEquals(flowsheetStartDate, milestoneArrayList.get(0).getStartDate());
        assertEquals(simpleDateFormat.parse("2016-11-09"), milestoneArrayList.get(0).getEndDate());
        assertEquals(simpleDateFormat.parse("2016-03-01"), milestoneArrayList.get(1).getStartDate());
        assertEquals(simpleDateFormat.parse("2016-03-31"), milestoneArrayList.get(1).getEndDate());
    }

}
