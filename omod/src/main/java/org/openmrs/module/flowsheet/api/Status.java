package org.openmrs.module.flowsheet.api;


public enum Status {

    NOT_APPLICABLE("Not Applicable"), PENDING("Pending"), DATA_ADDED("Data Added"), PLANNED("Planned");

    private String status;

    Status(String status) {
        this.status = status;
    }

}
