package com.mini_project.mini_project.language.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Language {

    public enum Proficiency {
        BASIC_CONVERSATION,
        BUSINESS,
        FLUENT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    @Enumerated(EnumType.STRING)
    private Proficiency proficiency;
}
