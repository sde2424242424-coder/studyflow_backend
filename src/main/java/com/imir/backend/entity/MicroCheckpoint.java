package com.imir.backend.entity;

import com.imir.backend.entity.enums.BreakReason;
import com.imir.backend.entity.enums.DistractionCountRange;
import com.imir.backend.entity.enums.MoodType;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DistractionCountRange distractionCountRange;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MoodType mood;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BreakReason breakReason;

    @Column(nullable = false)
    private int concentrationLevel;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudySession(StudySession studySession) {
        this.studySession = studySession;
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}