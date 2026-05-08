package com.imir.backend.dto.response;

import com.imir.backend.entity.enums.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FeedbackResponseDto {

    private Long id;
    private Long sessionId;

    private StudyPlace studyPlace;
    private StudyEnvironment studyEnvironment;

    private List<HelpfulFactor> helpfulFactors = new ArrayList<>();
    private List<DisturbingFactor> disturbingFactors = new ArrayList<>();

    private int productivityLevel;
    private DifficultyLevel difficultyLevel;
    private boolean needReview;
    private FatigueLevel fatigueLevel;
    private UnderstandingLevel understandingLevel;

    private LocalDateTime createdAt;

    public FeedbackResponseDto() {
    }

    public FeedbackResponseDto(Long id,
                               Long sessionId,
                               StudyPlace studyPlace,
                               StudyEnvironment studyEnvironment,
                               List<HelpfulFactor> helpfulFactors,
                               List<DisturbingFactor> disturbingFactors,
                               int productivityLevel,
                               DifficultyLevel difficultyLevel,
                               boolean needReview,
                               FatigueLevel fatigueLevel,
                               UnderstandingLevel understandingLevel,
                               LocalDateTime createdAt) {
        this.id = id;
        this.sessionId = sessionId;
        this.studyPlace = studyPlace;
        this.studyEnvironment = studyEnvironment;
        this.helpfulFactors = helpfulFactors;
        this.disturbingFactors = disturbingFactors;
        this.productivityLevel = productivityLevel;
        this.difficultyLevel = difficultyLevel;
        this.needReview = needReview;
        this.fatigueLevel = fatigueLevel;
        this.understandingLevel = understandingLevel;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getSessionId() {
        return sessionId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}