package com.imir.backend.dto.response;

import com.imir.backend.entity.enums.BreakReason;
import com.imir.backend.entity.enums.DistractionCountRange;
import com.imir.backend.entity.enums.MoodType;

import java.time.LocalDateTime;

public class MicroCheckpointResponseDto {

    private Long id;
    private Long sessionId;
    private DistractionCountRange distractionCountRange;
    private MoodType mood;
    private BreakReason breakReason;
    private int concentrationLevel;
    private LocalDateTime createdAt;

    public MicroCheckpointResponseDto() {
    }

    public MicroCheckpointResponseDto(Long id,
                                      Long sessionId,
                                      DistractionCountRange distractionCountRange,
                                      MoodType mood,
                                      BreakReason breakReason,
                                      int concentrationLevel,
                                      LocalDateTime createdAt) {
        this.id = id;
        this.sessionId = sessionId;
        this.distractionCountRange = distractionCountRange;
        this.mood = mood;
        this.breakReason = breakReason;
        this.concentrationLevel = concentrationLevel;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public DistractionCountRange getDistractionCountRange() {
        return distractionCountRange;
    }

    public MoodType getMood() {
        return mood;
    }

    public BreakReason getBreakReason() {
        return breakReason;
    }

    public int getConcentrationLevel() {
        return concentrationLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}