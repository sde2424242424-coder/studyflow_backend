package com.imir.backend.repository;

import com.imir.backend.entity.SessionFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionFeedbackRepository extends JpaRepository<SessionFeedback, Long> {

    Optional<SessionFeedback> findByStudySessionId(Long studySessionId);

    boolean existsByStudySessionId(Long studySessionId);
}