package com.imir.backend.dto.request;

import com.imir.backend.entity.enums.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRequestDto {

    @NotNull(message = "Study place is required")
    private StudyPlace studyPlace;

    @NotNull(message = "Study environment is required")
    private StudyEnvironment studyEnvironment;

    private List<HelpfulFactor> helpfulFactors = new ArrayList<>();

    private List<DisturbingFactor> disturbingFactors = new ArrayList<>();

    @Min(value = 1, message = "Productivity level must be at least 1")
    @Max(value = 5, message = "Productivity level must be at most 5")
    private int productivityLevel;

    @NotNull(message = "Difficulty level is required")
    private DifficultyLevel difficultyLevel;

    private boolean needReview;

    @NotNull(message = "Fatigue level is required")
    private FatigueLevel fatigueLevel;

    @NotNull(message = "Understanding level is required")
    private UnderstandingLevel understandingLevel;

    public FeedbackRequestDto() {
    }

    public StudyPlace getStudyPlace() {
        return studyPlace;
    }

    public StudyEnvironment getStudyEnvironment() {
        return studyEnvironment;
    }

    public List<HelpfulFactor> getHelpfulFactors() {
        return helpfulFactors;
    }

    public List<DisturbingFactor> getDisturbingFactors() {
        return disturbingFactors;
    }

    public int getProductivityLevel() {
        return productivityLevel;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public boolean isNeedReview() {
        return needReview;
    }

    public FatigueLevel getFatigueLevel() {
        return fatigueLevel;
    }

    public UnderstandingLevel getUnderstandingLevel() {
        return understandingLevel;
    }

    public void setStudyPlace(StudyPlace studyPlace) {
        this.studyPlace = studyPlace;
    }

    public void setStudyEnvironment(StudyEnvironment studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
    }

    public void setHelpfulFactors(List<HelpfulFactor> helpfulFactors) {
        this.helpfulFactors = helpfulFactors;
    }

    public void setDisturbingFactors(List<DisturbingFactor> disturbingFactors) {
        this.disturbingFactors = disturbingFactors;
    }

    public void setProductivityLevel(int productivityLevel) {
        this.productivityLevel = productivityLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setNeedReview(boolean needReview) {
        this.needReview = needReview;
    }

    public void setFatigueLevel(FatigueLevel fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }

    public void setUnderstandingLevel(UnderstandingLevel understandingLevel) {
        this.understandingLevel = understandingLevel;
    }
}