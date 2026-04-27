package com.imir.backend.controller;

import com.imir.backend.dto.request.FinishSessionRequestDto;
import com.imir.backend.dto.response.SessionResponseDto;
import com.imir.backend.service.StudySessionService;
import org.springframework.web.bind.annotation.*;

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
}