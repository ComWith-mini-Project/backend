package com.mini_project.mini_project.speciality.repository;

import com.mini_project.mini_project.speciality.entity.IndustryKnowledge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndustryKnowledgeRepository extends JpaRepository<IndustryKnowledge, Long> {
    List<IndustryKnowledge> findAllBySpecialityId(Long specialityId);
}