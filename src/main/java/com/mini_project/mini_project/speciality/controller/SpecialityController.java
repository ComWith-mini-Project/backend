package com.mini_project.mini_project.speciality.controller;

import com.mini_project.mini_project.speciality.dto.AddIndustryRequestDto;
import com.mini_project.mini_project.speciality.dto.AddSkillRequestDto;
import com.mini_project.mini_project.speciality.entity.SpecialitySkill;
import com.mini_project.mini_project.speciality.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career/speciality")
@RequiredArgsConstructor
public class SpecialityController {

    private final SpecialityService service;

    // 전체 조회
    @GetMapping
    public ResponseEntity<?> getSpeciality() {
        return ResponseEntity.ok(service.getSpeciality());
    }

    // 대표 스킬 추가
    @PostMapping("/signature-skill")
    public ResponseEntity<?> addSignatureSkill(@RequestBody AddSkillRequestDto dto) {
        service.addSkill(dto.getSkillName(), SpecialitySkill.SkillType.대표);
        return ResponseEntity.ok().build();
    }

    // 대표 스킬 삭제
    @DeleteMapping("/signature-skill/{id}")
    public ResponseEntity<?> deleteSignatureSkill(@PathVariable Long id) {
        service.deleteSkill(id, SpecialitySkill.SkillType.대표);
        return ResponseEntity.noContent().build();
    }

    // 일반 스킬 추가
    @PostMapping("/general-skill")
    public ResponseEntity<?> addGeneralSkill(@RequestBody AddSkillRequestDto dto) {
        service.addSkill(dto.getSkillName(), SpecialitySkill.SkillType.일반);
        return ResponseEntity.ok().build();
    }

    // 일반 스킬 삭제
    @DeleteMapping("/general-skill/{id}")
    public ResponseEntity<?> deleteGeneralSkill(@PathVariable Long id) {
        service.deleteSkill(id, SpecialitySkill.SkillType.일반);
        return ResponseEntity.noContent().build();
    }

    // 산업 지식 추가
    @PostMapping("/industry-knowledges")
    public ResponseEntity<?> addIndustry(@RequestBody AddIndustryRequestDto dto) {
        service.addIndustry(dto.getIndustryName());
        return ResponseEntity.ok().build();
    }

    // 산업 지식 삭제
    @DeleteMapping("/industry-knowledges/{id}")
    public ResponseEntity<?> deleteIndustry(@PathVariable Long id) {
        service.deleteIndustry(id);
        return ResponseEntity.noContent().build();
    }
}
