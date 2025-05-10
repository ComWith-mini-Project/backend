package com.mini_project.mini_project.speciality.repository;

import com.mini_project.mini_project.speciality.entity.SpecialitySkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialitySkillRepository extends JpaRepository<SpecialitySkill, Long> {
    List<SpecialitySkill> findAllBySpecialityIdAndType(Long specialityId, SpecialitySkill.SkillType type);
}