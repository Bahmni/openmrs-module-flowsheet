/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://www.bahmni.org/license/mplv2hd.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.flowsheet.definition.models;

import org.openmrs.Concept;
import org.openmrs.module.flowsheet.api.QuestionType;
import org.openmrs.module.flowsheet.api.models.Question;

import java.util.Set;

public class QuestionDefinition {
    private String name;
    private Set<Concept> concepts;
    private QuestionType questionType;

    public QuestionDefinition(String name, Set<Concept> concepts, QuestionType questionType) {
        this.name = name;
        this.concepts = concepts;
        this.questionType = questionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(Set<Concept> concepts) {
        this.concepts = concepts;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Question createQuestion() {
        return new Question(name, concepts, questionType);
    }

}
