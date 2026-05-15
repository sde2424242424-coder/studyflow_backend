package com.imir.backend.dto.response;

import com.imir.backend.entity.MicroCheckpoint;

import java.time.LocalDateTime;

public class MicroCheckpointResponseDto {

    private Long id;
    private String distractionCountRange;
    private String mood;
    private String breakReason;
    private Integer concentrationLevel;
    private Long createdAtMillis;
    private LocalDateTime createdAt;

    public MicroCheckpointResponseDto() {
    }

    public MicroCheckpointResponseDto(MicroCheckpoint checkpoint) {
        this.id = checkpoint.getId();
        this.distractionCountRange = checkpoint.getDistractionCountRange();
        this.mood = checkpoint.getMood();
        this.breakReason = checkpoint.getBreakReason();
        this.concentrationLevel = checkpoint.getConcentrationLevel();
        this.createdAtMillis = checkpoint.getCreatedAtMillis();
        this.createdAt = checkpoint.getCreatedAt();
    }

    public MicroCheckpointResponseDto(
            Long id,
            String distractionCountRange,
            String mood,
            String breakReason,
            Integer concentrationLevel,
            Long createdAtMillis,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.distractionCountRange = distractionCountRange;
        this.mood = mood;
        this.breakReason = breakReason;
        this.concentrationLevel = concentrationLevel;
        this.createdAtMillis = createdAtMillis;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getDistractionCountRange() {
        return distractionCountRange;
    }

    public String getMood() {
        return mood;
    }

    public String getBreakReason() {
        return breakReason;
    }

    public Integer getConcentrationLevel() {
        return concentrationLevel;
    }

    public Long getCreatedAtMillis() {
        return createdAtMillis;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDistractionCountRange(String distractionCountRange) {
        this.distractionCountRange = distractionCountRange;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setBreakReason(String breakReason) {
        this.breakReason = breakReason;
    }

    public void setConcentrationLevel(Integer concentrationLevel) {
        this.concentrationLevel = concentrationLevel;
    }

    public void setCreatedAtMillis(Long createdAtMillis) {
        this.createdAtMillis = createdAtMillis;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}