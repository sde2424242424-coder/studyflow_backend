package com.imir.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubjectRequestDto {

    private String title;
    private String description;
}