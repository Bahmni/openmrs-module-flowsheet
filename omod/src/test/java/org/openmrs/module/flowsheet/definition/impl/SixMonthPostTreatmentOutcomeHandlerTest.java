package org.openmrs.module.flowsheet.definition.impl;

import org.apache.commons.lang.time.DateUtils;
import org.bahmni.module.bahmnicore.dao.ObsDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openmrs.Obs;
import org.openmrs.PatientProgram;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.EOT_STOP_DATE;

public class SixMonthPostTreatmentOutcomeHandlerTest {
    @Mock
    ObsDao obsDao;

    @InjectMocks
    private SixMonthPostTreatmentOutcomeHandler sixMonthPostTreatmentOutcomeHandler;

    private PatientProgram patientProgram;
    private String patientProgramUuid;

    @Before
    public void setup() {
        initMocks(this);
        patientProgramUuid = "patientProgramUuid";
        patientProgram = new PatientProgram();
        patientProgram.setUuid(patientProgramUuid);
    }

    @Test
    public void shouldReturnNullIfSixMonthPostTreatmentOutcomeDateNotPresent() {
        when(obsDao.getObsByPatientProgramUuidAndConceptNames(patientProgramUuid, Arrays.asList(EOT_STOP_DATE), null, null, null, null)).thenReturn(null);

        Date actualTreatmentStartDate = sixMonthPostTreatmentOutcomeHandler.getDate(patientProgram);
        assertNull(actualTreatmentStartDate);
    }

    @Test
    public void shouldReturnDateWhenSixMonthPostTreatmentOutcomeDateIsPresentForPatientProgram() {
        Date today = new Date();
        Obs obs = new Obs();
        obs.setValueDate(today);

        when(obsDao.getObsByPatientProgramUuidAndConceptNames(patientProgramUuid, Arrays.asList(EOT_STOP_DATE), null, null, null, null)).thenReturn(Arrays.asList(obs));

        Date sixMonthPostTreatmentOutcomeHandlerDate = sixMonthPostTreatmentOutcomeHandler.getDate(patientProgram);

        assertEquals(DateUtils.addDays(today, 180), sixMonthPostTreatmentOutcomeHandlerDate);
    }


}