package com.imir.backend.dto.request;

import com.imir.backend.entity.enums.LearningType;
import jakarta.validation.constraints.NotNull;

public class StartSessionRequestDto {

    @NotNull(message = "Subject id is required")
    private Long subjectId;

    @NotNull(message = "Learning type is required")
    private LearningType learningType;

    public StartSessionRequestDto() {
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public LearningType getLearningType() {
        return learningType;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setLearningType(LearningType learningType) {
        this.learningType = learningType;
    }
}