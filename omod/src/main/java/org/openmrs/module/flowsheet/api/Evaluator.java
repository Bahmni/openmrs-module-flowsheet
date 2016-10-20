package org.openmrs.module.flowsheet.api;


import org.openmrs.Concept;
import org.openmrs.module.flowsheet.api.models.Result;

import java.util.Date;
import java.util.Set;

public interface Evaluator {
    Result evaluate(Set<Concept> concepts, Date startDate, Date endDate);
}
