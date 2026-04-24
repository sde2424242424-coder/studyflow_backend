package com.imir.backend.controller;

import com.example.studyflow.dto.request.CreateSubjectRequestDto;
import com.example.studyflow.dto.response.SubjectResponseDto;
import com.example.studyflow.service.SubjectService;
import lombok.RequiredArgsConstructor;
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
}
