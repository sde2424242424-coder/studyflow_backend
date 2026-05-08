package com.imir.backend.dto.request;

import com.imir.backend.entity.enums.BreakReason;
import com.imir.backend.entity.enums.DistractionCountRange;
import com.imir.backend.entity.enums.MoodType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MicroCheckpointRequestDto {

    @NotNull(message = "Distraction count range is required")
    private DistractionCountRange distractionCountRange;

    @NotNull(message = "Mood is required")
    private MoodType mood;

    @NotNull(message = "Break reason is required")
    private BreakReason breakReason;

    @Min(value = 1, message = "Concentration level must be at least 1")
    @Max(value = 5, message = "Concentration level must be at most 5")
    private int concentrationLevel;

    public MicroCheckpointRequestDto() {
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

    public void setDistractionCountRange(DistractionCountRange distractionCountRange) {
        this.distractionCountRange = distractionCountRange;
    }

    public void setMood(MoodType mood) {
        this.mood = mood;
    }

    public void setBreakReason(BreakReason breakReason) {
        this.breakReason = breakReason;
    }

    public void setConcentrationLevel(int concentrationLevel) {
        this.concentrationLevel = concentrationLevel;
    }
}