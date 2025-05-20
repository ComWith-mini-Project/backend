package com.mini_project.mini_project.url.service;

import com.mini_project.mini_project.url.dto.UrlRequestDto;
import com.mini_project.mini_project.url.entity.Url;
import com.mini_project.mini_project.url.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository repository;

    public List<Url> getByMember(Long memberId) {
        return repository.findByMemberId(memberId);
    }

    public List<Url> getByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }

    public List<Url> getByProject(Long projectId) {
        return repository.findByProjectId(projectId);
    }

    public Url create(UrlRequestDto dto) {
        Url url = Url.builder()
                .memberId(dto.getMemberId())
                .portfolioId(dto.getPortfolioId())
                .projectId(dto.getProjectId())
                .platform(dto.getPlatform())
                .url(dto.getUrl())
                .build();
        return repository.save(url);
    }

    public Url update(Long id, UrlRequestDto dto) {
        Url url = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("URL 정보를 찾을 수 없습니다."));

        url.setMemberId(dto.getMemberId());
        url.setPortfolioId(dto.getPortfolioId());
        url.setProjectId(dto.getProjectId());
        url.setPlatform(dto.getPlatform());
        url.setUrl(dto.getUrl());

        return repository.save(url);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
