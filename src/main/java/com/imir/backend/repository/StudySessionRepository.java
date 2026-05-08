package com.imir.backend.repository;

import com.imir.backend.entity.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {

    // История сессий по предмету
    List<StudySession> findBySubjectIdOrderByCreatedAtDesc(Long subjectId);

    // Все сессии пользователя
    List<StudySession> findByUserIdOrderByCreatedAtDesc(Long userId);

    // История сессий пользователя по конкретному предмету
    List<StudySession> findByUserIdAndSubjectIdOrderByCreatedAtDesc(Long userId, Long subjectId);
}