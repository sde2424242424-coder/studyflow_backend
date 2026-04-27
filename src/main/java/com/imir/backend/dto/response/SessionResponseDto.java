package com.imir.backend.dto.response;

import java.time.LocalDateTime;

public class SessionResponseDto {

    private Long id;
    private long durationSeconds;
    private int productivity;
    private int fatigue;
    private String notes;
    private LocalDateTime createdAt;
    private Long subjectId;

    public SessionResponseDto(Long id,
                              long durationSeconds,
                              int productivity,
                              int fatigue,
                              String notes,
                              LocalDateTime createdAt,
                              Long subjectId) {
        this.id = id;
        this.durationSeconds = durationSeconds;
        this.productivity = productivity;
        this.fatigue = fatigue;
        this.notes = notes;
        this.createdAt = createdAt;
        this.subjectId = subjectId;
    }

    public Long getId() { return id; }
    public long getDurationSeconds() { return durationSeconds; }
    public int getProductivity() { return productivity; }
    public int getFatigue() { return fatigue; }
    public String getNotes() { return notes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Long getSubjectId() { return subjectId; }
}