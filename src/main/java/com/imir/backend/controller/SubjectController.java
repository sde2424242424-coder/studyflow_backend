package com.imir.backend.controller;

import com.imir.backend.dto.request.CreateSubjectRequestDto;
import com.imir.backend.dto.request.SubjectNoteRequestDto;
import com.imir.backend.dto.response.SubjectResponseDto;
import com.imir.backend.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public SubjectResponseDto createSubject(@RequestBody CreateSubjectRequestDto request) {
        return subjectService.createSubject(request);
    }

    @GetMapping
    public List<SubjectResponseDto> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/{id}")
    public SubjectResponseDto getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{subjectId}/notes")
        public ResponseEntity<SubjectResponseDto> updateSubjectNotes(
                @PathVariable Long subjectId,
                @RequestBody SubjectNoteRequestDto requestDto,
                Authentication authentication
        ) {
            String userEmail = authentication.getName();

            SubjectResponseDto responseDto = subjectService.updateSubjectNotes(
                    subjectId,
                    requestDto.getNotes(),
                    userEmail
            );

            return ResponseEntity.ok(responseDto);
        }
}