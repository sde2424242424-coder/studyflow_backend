package com.imir.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public SubjectResponseDto(Long id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
}