package com.imir.backend.entity;

import com.imir.backend.entity.enums.DisturbingFactor;
import com.imir.backend.entity.enums.HelpfulFactor;
import com.imir.backend.entity.enums.StudyEnvironment;
import com.imir.backend.entity.enums.StudyPlace;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "session_feedbacks")
public class SessionFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_session_id", nullable = false)
    private StudySession studySession;

    @Enumerated(EnumType.STRING)
    private StudyPlace studyPlace;

    @Enumerated(EnumType.STRING)
    private StudyEnvironment studyEnvironment;

    @ElementCollection(targetClass = HelpfulFactor.class)
    @CollectionTable(
            name = "session_feedback_helpful_factors",
            joinColumns = @JoinColumn(name = "session_feedback_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "helpful_factor")
    private List<HelpfulFactor> helpfulFactors = new ArrayList<>();

    @ElementCollection(targetClass = DisturbingFactor.class)
    @CollectionTable(
            name = "session_feedback_disturbing_factors",
            joinColumns = @JoinColumn(name = "session_feedback_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "disturbing_factor")
    private List<DisturbingFactor> disturbingFactors = new ArrayList<>();

    private int productivityScore;

    private int difficultyScore;

    private boolean needReview;

    private int fatigueLevel;

    private int understandingLevel;

    @Column(length = 1000)
    private String memo;

    public SessionFeedback() {
    }

    public Long getId() {
        return id;
    }

    public StudySession getStudySession() {
        return studySession;
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

    public int getProductivityScore() {
        return productivityScore;
    }

    public int getDifficultyScore() {
        return difficultyScore;
    }

    public boolean isNeedReview() {
        return needReview;
    }

    public int getFatigueLevel() {
        return fatigueLevel;
    }

    public int getUnderstandingLevel() {
        return understandingLevel;
    }

    public String getMemo() {
        return memo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudySession(StudySession studySession) {
        this.studySession = studySession;
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

    public void setProductivityScore(int productivityScore) {
        this.productivityScore = productivityScore;
    }

    public void setDifficultyScore(int difficultyScore) {
        this.difficultyScore = difficultyScore;
    }

    public void setNeedReview(boolean needReview) {
        this.needReview = needReview;
    }

    public void setFatigueLevel(int fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }

    public void setUnderstandingLevel(int understandingLevel) {
        this.understandingLevel = understandingLevel;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}