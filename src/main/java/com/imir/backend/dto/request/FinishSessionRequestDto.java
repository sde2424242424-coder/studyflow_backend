package com.imir.backend.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FinishSessionRequestDto {

    // Старое поле. Можно временно оставить для совместимости.
    private Long subjectId;

    @NotNull(message = "Duration seconds is required")
    @Min(value = 0, message = "Duration seconds must be positive")
    private Long durationSeconds;

    // Старые поля. Потом лучше удалить.
    private int productivity;
    private int fatigue;

    private String notes;

    public FinishSessionRequestDto() {
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getDurationSeconds() {
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

    public void setDurationSeconds(Long durationSeconds) {
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