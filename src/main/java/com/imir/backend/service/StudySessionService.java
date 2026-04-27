package com.imir.backend.service;

import com.imir.backend.dto.request.FinishSessionRequestDto;
import com.imir.backend.entity.StudySession;
import com.imir.backend.entity.Subject;
import com.imir.backend.entity.User;
import com.imir.backend.repository.StudySessionRepository;
import com.imir.backend.repository.SubjectRepository;
import com.imir.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StudySessionService {

    private final StudySessionRepository sessionRepository;
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public StudySessionService(
            StudySessionRepository sessionRepository,
            SubjectRepository subjectRepository,
            UserRepository userRepository
    ) {
        this.sessionRepository = sessionRepository;
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    public StudySession finishSession(FinishSessionRequestDto request) {

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        // временно фиксированный user (потом заменим на JWT)
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        StudySession session = new StudySession();
        session.setSubject(subject);
        session.setUser(user);
        session.setDurationSeconds(request.getDurationSeconds());
        session.setProductivity(request.getProductivity());
        session.setFatigue(request.getFatigue());
        session.setNotes(request.getNotes());

        return sessionRepository.save(session);
    }
}