package com.imir.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubjectResponseDto {

    private Long id;
    private String title;
    private String description;
}