package com.imir.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "micro_checkpoints")
public class MicroCheckpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Каждый опрос на перерыве относится к одной учебной сессии
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_session_id", nullable = false)
    private StudySession studySession;

    @Column(nullable = false)
    private String distractionCountRange;

    @Column(nullable = false)
    private String mood;

    @Column(nullable = false)
    private String breakReason;

    @Column(nullable = false)
    private int concentrationLevel;

    private Long createdAtMillis;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public MicroCheckpoint() {
    }

    @PrePersist
    public void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public StudySession getStudySession() {
        return studySession;
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

    public int getConcentrationLevel() {
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

    public void setStudySession(StudySession studySession) {
        this.studySession = studySession;
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

    public void setConcentrationLevel(int concentrationLevel) {
        this.concentrationLevel = concentrationLevel;
    }

    public void setCreatedAtMillis(Long createdAtMillis) {
        this.createdAtMillis = createdAtMillis;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}