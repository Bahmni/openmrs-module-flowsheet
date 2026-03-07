/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://www.bahmni.org/license/mplv2hd.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.flowsheet.definition;

import org.openmrs.api.context.Context;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.SIX_MONTH_POST_TREATMENT_OUTCOME_HANDLER;
import static org.openmrs.module.flowsheet.constants.FlowsheetConstant.TREATMENT_END_DATE_HANDLER;

@Component
public class HandlerProvider {

    public Handler getHandler(String handler) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> handlerClass = Class.forName(handler);
        String name = getNameForHandler(handler);
        return (Handler) Context.getRegisteredComponent(name, handlerClass);
    }

    private String getNameForHandler(String handler) {
        if (handler.equals(TREATMENT_END_DATE_HANDLER)) {
            return "treatmentEndDateHandler";
        }
        if(handler.equals(SIX_MONTH_POST_TREATMENT_OUTCOME_HANDLER)) {
            return "sixMonthPostTreatmentOutcomeHandler";
        }
        return "";
    }
}
