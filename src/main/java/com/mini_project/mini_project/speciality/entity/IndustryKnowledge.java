package com.mini_project.mini_project.speciality.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndustryKnowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long industry_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @Column(nullable = false)
    private String industry_name;
}
