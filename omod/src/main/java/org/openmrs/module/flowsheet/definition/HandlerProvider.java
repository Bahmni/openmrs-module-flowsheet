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
