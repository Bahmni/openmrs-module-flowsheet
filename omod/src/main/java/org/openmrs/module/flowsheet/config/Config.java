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

public class Config {

    private String min;
    private String max;

    public String getMin() {
        return min;
    }

    @JsonProperty(FlowsheetConstant.MIN)
    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    @JsonProperty(FlowsheetConstant.MAX)
    public void setMax(String max) {
        this.max = max;
    }
}
