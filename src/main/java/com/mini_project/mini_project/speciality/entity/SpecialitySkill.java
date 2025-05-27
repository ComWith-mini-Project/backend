package com.mini_project.mini_project.speciality.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialitySkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @Column(nullable = false)
    private String SkillName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillType type;

    public enum SkillType {
        대표, 일반
    }
}
