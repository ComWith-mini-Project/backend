package com.mini_project.mini_project.language.repository;

import com.mini_project.mini_project.language.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
