package com.imir.backend.controller;

import com.imir.backend.dto.request.FinishSessionRequestDto;
import com.imir.backend.dto.response.SessionResponseDto;
import com.imir.backend.service.StudySessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class StudySessionController {

    private final StudySessionService sessionService;

    public StudySessionController(StudySessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public SessionResponseDto finishSession(@RequestBody FinishSessionRequestDto request) {
        return sessionService.finishSession(request);
    }

    @GetMapping("/subject/{subjectId}")
    public List<SessionResponseDto> getSessions(@PathVariable Long subjectId) {
        return sessionService.getSessionsBySubject(subjectId);
    }
}