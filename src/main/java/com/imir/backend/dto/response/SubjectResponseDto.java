package com.imir.backend.dto.response;

public class SubjectResponseDto {

    private Long id;
    private String title;
    private String description;

    private Integer plannedTotalMinutes;
    private Integer goalMinutesPerSession;
    private String learningType;
    private String notes;
    private String studyFrequency;

    public SubjectResponseDto(
            Long id,
            String title,
            String description,
            Integer plannedTotalMinutes,
            Integer goalMinutesPerSession,
            String learningType,
            String notes,
            String studyFrequency) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.plannedTotalMinutes = plannedTotalMinutes;
        this.goalMinutesPerSession = goalMinutesPerSession;
        this.learningType = learningType;
        this.notes = notes;
        this.studyFrequency = studyFrequency;
    }

    public Long getId() {
        return id;
    }

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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStudyFrequency() {
        return studyFrequency;
    }
}