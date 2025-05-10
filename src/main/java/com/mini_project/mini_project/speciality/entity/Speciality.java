package com.mini_project.mini_project.speciality.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 나중에 Member와 1:1 연결할 예정
    // @OneToOne
    // @JoinColumn(name = "member_id", nullable = false)
    // private Member member;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpecialitySkill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndustryKnowledge> industries = new ArrayList<>();
}
