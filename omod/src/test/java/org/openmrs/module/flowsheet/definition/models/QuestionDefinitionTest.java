/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://www.bahmni.org/license/mplv2hd.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.flowsheet.definition.models;

import org.openmrs.module.flowsheet.api.QuestionType;
import org.openmrs.module.flowsheet.api.models.Question;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openmrs.Concept;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertNotNull;

public class QuestionDefinitionTest {

    @Mock
    Concept systolic;

    @Mock
    Concept diastolic;

    QuestionDefinition questionDefinition;


    @Before
    public void setUp()  {
        questionDefinition = new QuestionDefinition("Blood Pressure", new LinkedHashSet<>(Arrays.asList(systolic, diastolic)), QuestionType.OBS);
    }


    @Test
    public void shouldCreateQuestion() {
        Question question = questionDefinition.createQuestion();
        assertNotNull(question);
    }

}