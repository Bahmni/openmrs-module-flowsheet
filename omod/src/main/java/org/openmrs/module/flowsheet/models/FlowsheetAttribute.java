/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://www.bahmni.org/license/mplv2hd.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.flowsheet.models;


import java.util.Date;

public class FlowsheetAttribute {

    private String patientEMRID;
    private String treatmentRegistrationNumber;
    private Date newDrugTreatmentStartDate;
    private Date mdrtbTreatmentStartDate;

    public String getPatientEMRID() {
        return patientEMRID;
    }

    public void setPatientEMRID(String patientEMRID) {
        this.patientEMRID = patientEMRID;
    }


    public Date getNewDrugTreatmentStartDate() {
        return newDrugTreatmentStartDate;
    }

    public void setNewDrugTreatmentStartDate(Date newDrugTreatmentStartDate) {
        this.newDrugTreatmentStartDate = newDrugTreatmentStartDate;
    }

    public Date getMdrtbTreatmentStartDate() {
        return mdrtbTreatmentStartDate;
    }

    public void setMdrtbTreatmentStartDate(Date mdrtbTreatmentStartDate) {
        this.mdrtbTreatmentStartDate = mdrtbTreatmentStartDate;
    }

    public String getTreatmentRegistrationNumber() {
        return treatmentRegistrationNumber;

    }

    public void setTreatmentRegistrationNumber(String treatmentRegistrationNumber) {
        this.treatmentRegistrationNumber = treatmentRegistrationNumber;
    }


}
