package com.imir.backend.dto.request;

import java.util.ArrayList;
import java.util.List;

public class FinishSessionRequestDto {

    private Long subjectId;
    private Long durationSeconds;
    private Long plannedSeconds;
    private Integer productivity;
    private Integer fatigue;
    private String notes;

    private String studyPlace;
    private String studyEnvironment;
    private List<String> helpfulFactors = new ArrayList<>();
    private List<String> disturbingFactors = new ArrayList<>();
    private String difficulty;
    private Boolean needReview;
    private String fatigueLevel;
    private Integer understanding;

    private List<MicroCheckpointRequestDto> microCheckpoints = new ArrayList<>();

    public FinishSessionRequestDto() {
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Long getPlannedSeconds() {
        return plannedSeconds;
    }

    public void setPlannedSeconds(Long plannedSeconds) {
        this.plannedSeconds = plannedSeconds;
    }

    public Integer getProductivity() {
        return productivity;
    }

    public void setProductivity(Integer productivity) {
        this.productivity = productivity;
    }

    public Integer getFatigue() {
        return fatigue;
    }

    public void setFatigue(Integer fatigue) {
        this.fatigue = fatigue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public void setStudyPlace(String studyPlace) {
        this.studyPlace = studyPlace;
    }

    public String getStudyEnvironment() {
        return studyEnvironment;
    }

    public void setStudyEnvironment(String studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
    }

    public List<String> getHelpfulFactors() {
        return helpfulFactors;
    }

    public void setHelpfulFactors(List<String> helpfulFactors) {
        this.helpfulFactors = helpfulFactors;
    }

    public List<String> getDisturbingFactors() {
        return disturbingFactors;
    }

    public void setDisturbingFactors(List<String> disturbingFactors) {
        this.disturbingFactors = disturbingFactors;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getNeedReview() {
        return needReview;
    }

    public void setNeedReview(Boolean needReview) {
        this.needReview = needReview;
    }

    public String getFatigueLevel() {
        return fatigueLevel;
    }

    public void setFatigueLevel(String fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }

    public Integer getUnderstanding() {
        return understanding;
    }

    public void setUnderstanding(Integer understanding) {
        this.understanding = understanding;
    }

    public List<MicroCheckpointRequestDto> getMicroCheckpoints() {
        return microCheckpoints;
    }

    public void setMicroCheckpoints(List<MicroCheckpointRequestDto> microCheckpoints) {
        this.microCheckpoints = microCheckpoints;
    }
}