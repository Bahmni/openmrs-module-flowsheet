package org.openmrs.module.flowsheet.constants;

public class FlowsheetConstant {



    private FlowsheetConstant() {
    }

    public static final String MILESTONES = "milestones";
    public static final String CONCEPTS = "concepts";
    public static final String TYPE = "type";
    public static final String NAME = "name";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String HANDLER = "handler" ;
    public static final String QUESTIONS = "questions";
    public static final String CONFIG = "config";

    //Concept
    public static final String EOT_STOP_DATE = "Tuberculosis treatment end date";
    public static final String DRUG_DELAMANID = "Delamanid";
    public static final String DRUG_BDQ = "Bedaquiline";
    public static final String TI_TREATMENT_START_DATE = "TUBERCULOSIS DRUG TREATMENT START DATE";
    public static final String PROGRAM_ATTRIBUTE_REG_NO = "Registration Number";

    //Handler
    public static final String TREATMENT_END_DATE_HANDLER = "org.openmrs.module.flowsheet.definition.impl.TreatmentEndDateHandler";
    public static final String SIX_MONTH_POST_TREATMENT_OUTCOME_HANDLER = "org.openmrs.module.flowsheet.definition.impl.SixMonthPostTreatmentOutcomeHandler";

}
