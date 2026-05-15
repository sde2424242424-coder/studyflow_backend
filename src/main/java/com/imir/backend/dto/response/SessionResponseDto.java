package com.imir.backend.dto.response;

import com.imir.backend.entity.StudySession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SessionResponseDto {

    private Long id;
    private Long subjectId;
    private Long durationSeconds;
    private Long plannedSeconds;
    private Integer productivity;
    private Integer fatigue;
    private String notes;
    private LocalDateTime createdAt;

    private String studyPlace;
    private String studyEnvironment;
    private List<String> helpfulFactors;
    private List<String> disturbingFactors;
    private String difficulty;
    private Boolean needReview;
    private String fatigueLevel;
    private Integer understanding;
    private List<MicroCheckpointResponseDto> microCheckpoints;

    public SessionResponseDto(StudySession session) {
        this.id = session.getId();

        if (session.getSubject() != null) {
            this.subjectId = session.getSubject().getId();
        }

        this.durationSeconds = session.getDurationSeconds();
        this.plannedSeconds = session.getPlannedSeconds();
        this.productivity = session.getProductivity();
        this.fatigue = session.getFatigue();
        this.notes = session.getNotes();
        this.createdAt = session.getCreatedAt();

        this.studyPlace = session.getStudyPlace();
        this.studyEnvironment = session.getStudyEnvironment();
        this.helpfulFactors = session.getHelpfulFactors() != null
                ? session.getHelpfulFactors()
                : new ArrayList<>();

        this.disturbingFactors = session.getDisturbingFactors() != null
                ? session.getDisturbingFactors()
                : new ArrayList<>();

        this.difficulty = session.getDifficulty();
        this.needReview = session.getNeedReview();
        this.fatigueLevel = session.getFatigueLevel();
        this.understanding = session.getUnderstanding();

        this.microCheckpoints = new ArrayList<>();

        if (session.getMicroCheckpoints() != null) {
            this.microCheckpoints = session.getMicroCheckpoints()
                    .stream()
                    .map(MicroCheckpointResponseDto::new)
                    .toList();
        }
    }

    public Long getId() {
        return id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public Long getPlannedSeconds() {
        return plannedSeconds;
    }

    public Integer getProductivity() {
        return productivity;
    }

    public Integer getFatigue() {
        return fatigue;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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

    public List<MicroCheckpointResponseDto> getMicroCheckpoints() {
        return microCheckpoints;
    }
}