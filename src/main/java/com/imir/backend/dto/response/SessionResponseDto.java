package com.imir.backend.dto.response;

import com.imir.backend.entity.enums.LearningType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class SessionResponseDto {

    private Long id;
    private Long subjectId;

    private LearningType learningType;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    private long durationSeconds;

    private DayOfWeek dayOfWeek;

    private boolean hadBreak;
    private int breakCount;
    private int studyStreakDays;

    // Старые поля. Пока оставляем для совместимости.
    private int productivity;
    private int fatigue;

    private String notes;
    private LocalDateTime createdAt;

    public SessionResponseDto() {
    }

    public SessionResponseDto(Long id,
                              Long subjectId,
                              LearningType learningType,
                              LocalDateTime startedAt,
                              LocalDateTime endedAt,
                              long durationSeconds,
                              DayOfWeek dayOfWeek,
                              boolean hadBreak,
                              int breakCount,
                              int studyStreakDays,
                              int productivity,
                              int fatigue,
                              String notes,
                              LocalDateTime createdAt) {
        this.id = id;
        this.subjectId = subjectId;
        this.learningType = learningType;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.durationSeconds = durationSeconds;
        this.dayOfWeek = dayOfWeek;
        this.hadBreak = hadBreak;
        this.breakCount = breakCount;
        this.studyStreakDays = studyStreakDays;
        this.productivity = productivity;
        this.fatigue = fatigue;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public LearningType getLearningType() {
        return learningType;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public long getDurationSeconds() {
        return durationSeconds;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isHadBreak() {
        return hadBreak;
    }

    public int getBreakCount() {
        return breakCount;
    }

    public int getStudyStreakDays() {
        return studyStreakDays;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}