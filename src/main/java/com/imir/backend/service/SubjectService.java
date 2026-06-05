package com.imir.backend.service;

import com.imir.backend.dto.request.CreateSubjectRequestDto;
import com.imir.backend.dto.response.SubjectResponseDto;
import com.imir.backend.entity.Subject;
import com.imir.backend.entity.User;
import com.imir.backend.dto.request.SubjectNoteRequestDto;
import com.imir.backend.repository.SubjectRepository;
import com.imir.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public SubjectResponseDto createSubject(CreateSubjectRequestDto request) {
        User user = getCurrentUser();

        Subject subject = new Subject();
        subject.setTitle(request.getTitle());
        subject.setDescription(request.getDescription());
        subject.setUser(user);
        subject.setPlannedTotalMinutes(request.getPlannedTotalMinutes());
        subject.setGoalMinutesPerSession(request.getGoalMinutesPerSession());
        subject.setLearningType(request.getLearningType());
        subject.setNotes(request.getNotes());

        if (request.getStudyFrequency() != null) {
            subject.setStudyFrequency(request.getStudyFrequency());
        } else {
            subject.setStudyFrequency(request.getLearningType());
        }

        Subject saved = subjectRepository.save(subject);

        return toDto(saved);
    }

    public List<SubjectResponseDto> getSubjects() {
        User user = getCurrentUser();

        return subjectRepository.findByUserId(user.getId())
        .stream()
        .map(this::toDto)
        .toList();
    }

    public SubjectResponseDto getSubjectById(Long id) {
        User user = getCurrentUser();

        Subject subject = subjectRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        return toDto(subject);
    }

    @Transactional
    public void deleteSubject(Long subjectId) {
        User user = getCurrentUser();

        Subject subject = subjectRepository.findByIdAndUserId(subjectId, user.getId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subjectRepository.delete(subject);
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private SubjectResponseDto toDto(Subject subject) {
        return new SubjectResponseDto(
                subject.getId(),
                subject.getTitle(),
                subject.getDescription(),
                subject.getPlannedTotalMinutes(),
                subject.getGoalMinutesPerSession(),
                subject.getLearningType(),
                subject.getNotes(),
                subject.getStudyFrequency()
        );
    }

    @Transactional
    public SubjectResponseDto updateSubjectNotes(Long subjectId, String notes, String userEmail) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        if (!subject.getUser().getEmail().equals(userEmail)) {
            throw new RuntimeException("Access denied");
        }

        subject.setNotes(notes == null ? "" : notes);

        Subject savedSubject = subjectRepository.save(subject);

        return toDto(savedSubject);
    }
}