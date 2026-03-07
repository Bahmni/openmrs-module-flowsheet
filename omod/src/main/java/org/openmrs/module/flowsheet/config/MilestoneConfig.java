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

public class MilestoneConfig {

    private String name;
    private String handler;
    private Config config;
    private List<String> questionNames;

    public String getName() {
        return name;
    }

    @JsonProperty(FlowsheetConstant.NAME)
    public void setName(String name) {
        this.name = name;
    }

    public String getHandler() {
        return handler;
    }

    @JsonProperty(FlowsheetConstant.HANDLER)
    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Config getConfig() {
        return config;
    }

    @JsonProperty(FlowsheetConstant.CONFIG)
    public void setConfig(Config config) {
        this.config = config;
    }

    public List<String> getQuestionNames() {
        return questionNames;
    }

    @JsonProperty(FlowsheetConstant.QUESTIONS)
    public void setQuestionNames(List<String> questionNames) {
        this.questionNames = questionNames;
    }
}
