package com.mini_project.mini_project.speciality.service;

import com.mini_project.mini_project.speciality.entity.*;
import com.mini_project.mini_project.speciality.repository.IndustryKnowledgeRepository;
import com.mini_project.mini_project.speciality.repository.SpecialityRepository;
import com.mini_project.mini_project.speciality.repository.SpecialitySkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SpecialityService {

    private final SpecialityRepository specialityRepository;
    private final SpecialitySkillRepository skillRepository;
    private final IndustryKnowledgeRepository industryRepository;

    // Speciality 조회
    public Speciality getSpeciality() {
        return specialityRepository.findById(1L)
                .orElseThrow(() -> new NoSuchElementException("Speciality not found"));
    }

    // 대표/일반 스킬 추가
    public void addSkill(String skillName, SpecialitySkill.SkillType type) {
        Speciality speciality = getSpeciality();

        SpecialitySkill skill = new SpecialitySkill();
        skill.setSpeciality(speciality);
        skill.setSkillName(skillName);
        skill.setType(type);

        skillRepository.save(skill);
    }

    // 대표/일반 스킬 삭제
    public void deleteSkill(Long skillId, SpecialitySkill.SkillType type) {
        SpecialitySkill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new NoSuchElementException("Skill not found"));

        if (skill.getType() != type) {
            throw new IllegalArgumentException("Skill type mismatch");
        }

        skillRepository.delete(skill);
    }

    // 산업 지식 추가
    public void addIndustry(String industryName) {
        Speciality speciality = getSpeciality();

        IndustryKnowledge knowledge = new IndustryKnowledge();
        knowledge.setSpeciality(speciality);
        knowledge.setIndustryName(industryName);

        industryRepository.save(knowledge);
    }

    // 산업 지식 삭제
    public void deleteIndustry(Long industryId) {
        IndustryKnowledge knowledge = industryRepository.findById(industryId)
                .orElseThrow(() -> new NoSuchElementException("Industry knowledge not found"));

        industryRepository.delete(knowledge);
    }

    // 전체 스킬 조회
    public List<SpecialitySkill> getAllSkillsByType(SpecialitySkill.SkillType type) {
        return skillRepository.findAllBySpecialityIdAndType(1L, type);
    }

    // 전체 산업 지식 조회
    public List<IndustryKnowledge> getAllIndustries() {
        return industryRepository.findAllBySpecialityId(1L);
    }
}
