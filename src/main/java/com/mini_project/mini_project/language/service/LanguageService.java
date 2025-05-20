package com.mini_project.mini_project.language.service;

import com.mini_project.mini_project.language.dto.LanguageRequestDto;
import com.mini_project.mini_project.language.entity.Language;
import com.mini_project.mini_project.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository repository;

    public List<Language> getAll() {
        return repository.findAll();
    }

    public Language create(LanguageRequestDto dto) {
        Language language = Language.builder()
                .language(dto.getLanguage())
                .proficiency(dto.getProficiency())
                .build();

        return repository.save(language);
    }

    public Language update(Long id, LanguageRequestDto dto) {
        Language language = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("외국어 정보를 찾을 수 없습니다."));

        language.setLanguage(dto.getLanguage());
        language.setProficiency(dto.getProficiency());

        return repository.save(language);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
