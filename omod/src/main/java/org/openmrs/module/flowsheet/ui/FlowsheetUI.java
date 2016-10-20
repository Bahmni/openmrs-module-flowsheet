package org.openmrs.module.flowsheet.ui;

import org.openmrs.module.flowsheet.api.models.Milestone;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlowsheetUI {

    private List<Milestone> milestones;
    private Map<String, List<String>> flowsheetData;
    private String highlightedMilestone;

    public Map<String, List<String>> getFlowsheetData() {
        if(null == this.flowsheetData) {
            this.flowsheetData = new LinkedHashMap<>();
        }
        return this.flowsheetData;
    }

    public void setFlowsheetData(Map<String, List<String>> flowsheetData) {
        this.flowsheetData = flowsheetData;
    }

    public String getHighlightedMilestone() {
        return highlightedMilestone;
    }

    public void setHighlightedMilestone(String highlightedMilestone) {
        this.highlightedMilestone = highlightedMilestone;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }
}
