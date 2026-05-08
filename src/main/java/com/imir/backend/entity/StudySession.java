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

    // Один предмет может иметь много учебных сессий
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    // Один пользователь может иметь много учебных сессий
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Тип обучения выбирается при старте сессии
    @Enumerated(EnumType.STRING)
    private LearningType learningType;

    // Время начала сессии
    @Column(nullable = false)
    private LocalDateTime startedAt;

    // Время завершения сессии
    private LocalDateTime endedAt;

    // Сколько секунд длилась сессия
    @Column(nullable = false)
    private long durationSeconds;

    // День недели собирается автоматически
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    // Был ли хотя бы один перерыв
    private boolean hadBreak;

    // Количество перерывов
    private int breakCount;

    // Количество дней подряд
    private int studyStreakDays;

    // Старое поле. Пока оставляем, чтобы не сломать текущий код.
    private int productivity;

    // Старое поле. Пока оставляем, чтобы не сломать текущий код.
    private int fatigue;

    @Column(length = 1000)
    private String notes;

    // Одна сессия может иметь много опросов на перерыве
    @OneToMany(mappedBy = "studySession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MicroCheckpoint> microCheckpoints = new ArrayList<>();

    // Одна сессия имеет один финальный отзыв
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