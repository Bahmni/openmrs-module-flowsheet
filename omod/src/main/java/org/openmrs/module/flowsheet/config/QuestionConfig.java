/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://www.bahmni.org/license/mplv2hd.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.flowsheet.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.openmrs.module.flowsheet.constants.FlowsheetConstant;

import java.util.List;

public class QuestionConfig {
    private String name;
    private List<String> concepts;
    private String type;

    public String getName() {
        return name;
    }

    @JsonProperty(FlowsheetConstant.NAME)
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getConcepts() {
        return concepts;
    }

    @JsonProperty(FlowsheetConstant.CONCEPTS)
    public void setConcepts(List<String> concepts) {
        this.concepts = concepts;
    }

    public String getType() {
        return type;
    }

    @JsonProperty(FlowsheetConstant.TYPE)
    public void setType(String type) {
        this.type = type;
    }
}
