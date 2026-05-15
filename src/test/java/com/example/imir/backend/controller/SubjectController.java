package com.imir.backend.controller;

import com.imir.backend.entity.User;
import com.imir.backend.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(
            @PathVariable Long subjectId,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();

        subjectService.deleteSubject(subjectId, user.getId());

        return ResponseEntity.noContent().build();
    }
}