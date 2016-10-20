package org.openmrs.module.flowsheet.service;

import org.bahmni.module.bahmnicore.model.bahmniPatientProgram.BahmniPatientProgram;
import org.openmrs.Concept;
import org.openmrs.OrderType;
import org.openmrs.PatientIdentifierType;
import org.openmrs.PatientProgram;
import org.openmrs.module.flowsheet.config.FlowsheetConfig;
import org.openmrs.module.flowsheet.definition.models.FlowsheetDefinition;
import org.openmrs.module.flowsheet.models.FlowsheetAttribute;
import org.openmrs.module.flowsheet.ui.FlowsheetUI;

import java.util.Date;
import java.util.Set;

public interface PatientMonitoringFlowsheetService {
    FlowsheetUI getFlowsheetForPatientProgram(PatientProgram patientProgram, Date startDate, Date endDate, String configFilePath) throws Exception;

    FlowsheetAttribute getFlowsheetAttributesForPatientProgram(BahmniPatientProgram bahmniPatientProgram, PatientIdentifierType patientIdentifierType, OrderType orderType, Set<Concept> concepts);

    Date getStartDateForDrugConcepts(String patientProgramUuid, Set<String> drugConcepts, OrderType orderType);

    FlowsheetDefinition getFlowsheetDefinitionFromConfig(FlowsheetConfig flowsheetConfig, Date startDate);
}
