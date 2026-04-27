package com.imir.backend.dto.request;

public class FinishSessionRequestDto {

    private Long subjectId;
    private long durationSeconds;
    private int productivity;
    private int fatigue;
    private String notes;

    public FinishSessionRequestDto() {
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public long getDurationSeconds() {
        return durationSeconds;
    }

    public int getProductivity() {
        return productivity;
    }

    public int getFatigue() {
        return fatigue;
    }

    public String getNotes() {
        return notes;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setDurationSeconds(long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}