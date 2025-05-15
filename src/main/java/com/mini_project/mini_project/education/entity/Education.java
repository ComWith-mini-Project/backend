package com.mini_project.mini_project.education.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String school;
    private String major;
    private String startDate;
    private String endDate;

    private boolean isCurrent;

    @Column(columnDefinition = "TEXT")
    private String description;
}
