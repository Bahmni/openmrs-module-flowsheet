/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://www.bahmni.org/license/mplv2hd.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.flowsheet.api;


import org.openmrs.Concept;
import org.openmrs.module.flowsheet.api.models.Result;

import java.util.Date;
import java.util.Set;

public interface Evaluator {
    Result evaluate(Set<Concept> concepts, Date startDate, Date endDate);
}
