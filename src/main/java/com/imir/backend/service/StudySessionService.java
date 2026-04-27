package com.imir.backend.service;

import com.imir.backend.dto.request.FinishSessionRequestDto;
import com.imir.backend.dto.response.SessionResponseDto;
import com.imir.backend.entity.StudySession;
import com.imir.backend.entity.Subject;
import com.imir.backend.entity.User;
import com.imir.backend.repository.StudySessionRepository;
import com.imir.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySessionService {

    private final StudySessionRepository sessionRepository;
    private final SubjectRepository subjectRepository;

    public StudySessionService(
            StudySessionRepository sessionRepository,
            SubjectRepository subjectRepository
    ) {
        this.sessionRepository = sessionRepository;
        this.subjectRepository = subjectRepository;
    }

    public SessionResponseDto finishSession(FinishSessionRequestDto request) {

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        User user = subject.getUser();

        StudySession session = new StudySession();
        session.setSubject(subject);
        session.setUser(user);
        session.setDurationSeconds(request.getDurationSeconds());
        session.setProductivity(request.getProductivity());
        session.setFatigue(request.getFatigue());
        session.setNotes(request.getNotes());

        StudySession saved = sessionRepository.save(session);

        return new SessionResponseDto(
                saved.getId(),
                saved.getDurationSeconds(),
                saved.getProductivity(),
                saved.getFatigue(),
                saved.getNotes(),
                saved.getCreatedAt(),
                saved.getSubject().getId()
        );
    }

    public List<SessionResponseDto> getSessionsBySubject(Long subjectId) {

        return sessionRepository.findBySubjectIdOrderByCreatedAtDesc(subjectId)
                .stream()
                .map(s -> new SessionResponseDto(
                        s.getId(),
                        s.getDurationSeconds(),
                        s.getProductivity(),
                        s.getFatigue(),
                        s.getNotes(),
                        s.getCreatedAt(),
                        s.getSubject().getId()
                ))
                .toList();
    }
}