package com.imir.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Integer plannedTotalMinutes;

    private Integer goalMinutesPerSession;

    private String learningType;

    private String notes;

    private String studyFrequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudySession> studySessions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public List<StudySession> getStudySessions() {
        return studySessions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStudySessions(List<StudySession> studySessions) {
        this.studySessions = studySessions;
    }

    public Integer getPlannedTotalMinutes() {
    return plannedTotalMinutes;
    }

    public void setPlannedTotalMinutes(Integer plannedTotalMinutes) {
        this.plannedTotalMinutes = plannedTotalMinutes;
    }

    public Integer getGoalMinutesPerSession() {
        return goalMinutesPerSession;
    }

    public void setGoalMinutesPerSession(Integer goalMinutesPerSession) {
        this.goalMinutesPerSession = goalMinutesPerSession;
    }

    public String getLearningType() {
        return learningType;
    }

    public void setLearningType(String learningType) {
        this.learningType = learningType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStudyFrequency() {
        return studyFrequency;
    }

    public void setStudyFrequency(String studyFrequency) {
        this.studyFrequency = studyFrequency;
    }
}