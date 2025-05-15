package com.mini_project.mini_project.education.service;

import com.mini_project.mini_project.education.dto.EducationRequestDto;
import com.mini_project.mini_project.education.entity.Education;
import com.mini_project.mini_project.education.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    public Education create(EducationRequestDto dto) {
        Education education = Education.builder()
                .school(dto.getSchool())
                .major(dto.getMajor())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .isCurrent(dto.isCurrent())
                .description(dto.getDescription())
                .build();
        return educationRepository.save(education);
    }

    public Education update(Long id, EducationRequestDto dto) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 학력을 찾을 수 없습니다."));
        education.setSchool(dto.getSchool());
        education.setMajor(dto.getMajor());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        education.setCurrent(dto.isCurrent());
        education.setDescription(dto.getDescription());

        return educationRepository.save(education);
    }

    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

}
