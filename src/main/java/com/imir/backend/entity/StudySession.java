package com.imir.backend.entity;

import com.imir.backend.entity.enums.LearningType;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_sessions")
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private LearningType learningType;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    @Column(nullable = false)
    private long durationSeconds;

    private Long plannedSeconds;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private boolean hadBreak;

    private int breakCount;

    private int studyStreakDays;

    private String studyPlace;

    private String studyEnvironment;

    @ElementCollection
    @CollectionTable(
            name = "study_session_helpful_factors",
            joinColumns = @JoinColumn(name = "study_session_id")
    )
    @Column(name = "factor")
    private List<String> helpfulFactors = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "study_session_disturbing_factors",
            joinColumns = @JoinColumn(name = "study_session_id")
    )
    @Column(name = "factor")
    private List<String> disturbingFactors = new ArrayList<>();

    private String difficulty;

    private Boolean needReview;

    private String fatigueLevel;

    private Integer understanding;

    private int productivity;

    private int fatigue;

    @Column(length = 1000)
    private String notes;

    @OneToMany(mappedBy = "studySession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MicroCheckpoint> microCheckpoints = new ArrayList<>();

    @OneToOne(mappedBy = "studySession", cascade = CascadeType.ALL, orphanRemoval = true)
    private SessionFeedback sessionFeedback;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public StudySession() {
    }

    @PrePersist
    public void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }

        if (this.startedAt == null) {
            this.startedAt = LocalDateTime.now();
        }

        if (this.dayOfWeek == null) {
            this.dayOfWeek = this.startedAt.getDayOfWeek();
        }

        if (this.studyStreakDays == 0) {
            this.studyStreakDays = 1;
        }
    }

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public User getUser() {
        return user;
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

    public Long getPlannedSeconds() {
        return plannedSeconds;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isHadBreak() {
        return hadBreak;
    }

    public boolean getHadBreak() {
        return hadBreak;
    }

    public int getBreakCount() {
        return breakCount;
    }

    public int getStudyStreakDays() {
        return studyStreakDays;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public String getStudyEnvironment() {
        return studyEnvironment;
    }

    public List<String> getHelpfulFactors() {
        return helpfulFactors;
    }

    public List<String> getDisturbingFactors() {
        return disturbingFactors;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Boolean getNeedReview() {
        return needReview;
    }

    public String getFatigueLevel() {
        return fatigueLevel;
    }

    public Integer getUnderstanding() {
        return understanding;
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

    public List<MicroCheckpoint> getMicroCheckpoints() {
        return microCheckpoints;
    }

    public SessionFeedback getSessionFeedback() {
        return sessionFeedback;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLearningType(LearningType learningType) {
        this.learningType = learningType;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public void setDurationSeconds(long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public void setPlannedSeconds(Long plannedSeconds) {
        this.plannedSeconds = plannedSeconds;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setHadBreak(boolean hadBreak) {
        this.hadBreak = hadBreak;
    }

    public void setBreakCount(int breakCount) {
        this.breakCount = breakCount;
    }

    public void setStudyStreakDays(int studyStreakDays) {
        this.studyStreakDays = studyStreakDays;
    }

    public void setStudyPlace(String studyPlace) {
        this.studyPlace = studyPlace;
    }

    public void setStudyEnvironment(String studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
    }

    public void setHelpfulFactors(List<String> helpfulFactors) {
        this.helpfulFactors = helpfulFactors;
    }

    public void setDisturbingFactors(List<String> disturbingFactors) {
        this.disturbingFactors = disturbingFactors;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setNeedReview(Boolean needReview) {
        this.needReview = needReview;
    }

    public void setFatigueLevel(String fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }

    public void setUnderstanding(Integer understanding) {
        this.understanding = understanding;
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

    public void setMicroCheckpoints(List<MicroCheckpoint> microCheckpoints) {
        this.microCheckpoints = microCheckpoints;
    }

    public void setSessionFeedback(SessionFeedback sessionFeedback) {
        this.sessionFeedback = sessionFeedback;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}