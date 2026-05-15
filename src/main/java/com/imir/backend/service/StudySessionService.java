package com.imir.backend.service;

import com.imir.backend.dto.request.FinishSessionRequestDto;
import com.imir.backend.dto.request.MicroCheckpointRequestDto;
import com.imir.backend.dto.response.SessionResponseDto;
import com.imir.backend.entity.MicroCheckpoint;
import com.imir.backend.entity.StudySession;
import com.imir.backend.entity.Subject;
import com.imir.backend.entity.User;
import com.imir.backend.repository.StudySessionRepository;
import com.imir.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        //session.setLearningType(request.getLearningType());

        session.setDurationSeconds(request.getDurationSeconds());
        session.setPlannedSeconds(request.getPlannedSeconds());

        session.setProductivity(request.getProductivity());
        session.setFatigue(request.getFatigue());
        session.setNotes(request.getNotes());

        session.setStudyPlace(request.getStudyPlace());
        session.setStudyEnvironment(request.getStudyEnvironment());
        session.setHelpfulFactors(request.getHelpfulFactors());
        session.setDisturbingFactors(request.getDisturbingFactors());
        session.setDifficulty(request.getDifficulty());
        session.setNeedReview(request.getNeedReview());
        session.setFatigueLevel(request.getFatigueLevel());
        session.setUnderstanding(request.getUnderstanding());

        session.setEndedAt(LocalDateTime.now());

        boolean hasMicroCheckpoints =
                request.getMicroCheckpoints() != null &&
                        !request.getMicroCheckpoints().isEmpty();

        session.setHadBreak(hasMicroCheckpoints);
        session.setBreakCount(
                hasMicroCheckpoints ? request.getMicroCheckpoints().size() : 0
        );

        if (hasMicroCheckpoints) {
            for (MicroCheckpointRequestDto checkpointDto : request.getMicroCheckpoints()) {
                MicroCheckpoint checkpoint = new MicroCheckpoint();

                checkpoint.setStudySession(session);
                checkpoint.setDistractionCountRange(checkpointDto.getDistractionCountRange());
                checkpoint.setMood(checkpointDto.getMood());
                checkpoint.setBreakReason(checkpointDto.getBreakReason());

                if (checkpointDto.getConcentrationLevel() != null) {
                    checkpoint.setConcentrationLevel(checkpointDto.getConcentrationLevel());
                } else {
                    checkpoint.setConcentrationLevel(3);
                }

                checkpoint.setCreatedAtMillis(checkpointDto.getCreatedAtMillis());

                session.getMicroCheckpoints().add(checkpoint);
            }
        }

        StudySession saved = sessionRepository.save(session);

        return new SessionResponseDto(saved);
    }

    public List<SessionResponseDto> getSessionsBySubject(Long subjectId) {
        return sessionRepository.findBySubjectIdOrderByCreatedAtDesc(subjectId)
                .stream()
                .map(SessionResponseDto::new)
                .toList();
    }
}