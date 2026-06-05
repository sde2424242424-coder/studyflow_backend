package com.imir.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubjectRequestDto {

    private String title;
    private String description;

    private Integer plannedTotalMinutes;
    private Integer goalMinutesPerSession;
    private String learningType;
    private String notes;
    private String studyFrequency;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPlannedTotalMinutes() {
        return plannedTotalMinutes;
    }

    public Integer getGoalMinutesPerSession() {
        return goalMinutesPerSession;
    }

    public String getLearningType() {
        return learningType;
    }

    public String getNotes() {
        return notes;
    }

    public String getStudyFrequency() {
        return studyFrequency;
    }
}