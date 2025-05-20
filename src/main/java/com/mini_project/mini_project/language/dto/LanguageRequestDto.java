package com.mini_project.mini_project.language.dto;

import com.mini_project.mini_project.language.entity.Language;
import lombok.Data;

@Data
public class LanguageRequestDto {
    private String language;
    private Language.Proficiency proficiency;
}
