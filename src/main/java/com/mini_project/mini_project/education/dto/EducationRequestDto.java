package com.mini_project.mini_project.education.dto;

import lombok.Data;

@Data
public class EducationRequestDto {

    private Long id;
    private String school;
    private String major;
    private String startDate;
    private String endDate;
    private boolean isCurrent;
    private String description;
}
