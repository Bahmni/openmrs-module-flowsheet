package org.openmrs.module.flowsheet.definition.impl;


import org.apache.commons.lang.time.DateUtils;
import org.bahmni.module.bahmnicore.dao.ObsDao;
import org.openmrs.Obs;
import org.openmrs.PatientProgram;
import org.openmrs.module.flowsheet.definition.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.EOT_STOP_DATE;

@Component
public class SixMonthPostTreatmentOutcomeHandler implements Handler{

    private ObsDao obsDao;

    @Autowired
    public SixMonthPostTreatmentOutcomeHandler(ObsDao obsDao) {
        this.obsDao = obsDao;
    }

    @Override
    public Date getDate(PatientProgram patientProgram) {
        List<Obs> sixMonthPostTreatmentOutcomeDate = obsDao.getObsByPatientProgramUuidAndConceptNames(patientProgram.getUuid(), Arrays.asList(EOT_STOP_DATE), null, null, null, null);

        if(CollectionUtils.isEmpty(sixMonthPostTreatmentOutcomeDate)){
            return  null;
        }
        return DateUtils.addDays(sixMonthPostTreatmentOutcomeDate.get(0).getValueDate(), 180);
    }
}
