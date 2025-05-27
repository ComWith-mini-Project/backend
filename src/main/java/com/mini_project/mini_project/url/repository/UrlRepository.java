package com.mini_project.mini_project.url.repository;

import com.mini_project.mini_project.url.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlRepository extends JpaRepository<Url, Long> {
    List<Url> findByMemberId(Long memberId);
    List<Url> findByPortfolioId(Long portfolioId);
    List<Url> findByProjectId(Long projectId);
}
