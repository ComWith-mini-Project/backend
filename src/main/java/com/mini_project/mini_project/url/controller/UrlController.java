package com.mini_project.mini_project.url.controller;

import com.mini_project.mini_project.url.dto.UrlRequestDto;
import com.mini_project.mini_project.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career/urls")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<?> getByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(service.getByMember(memberId));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<?> getByPortfolio(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(service.getByPortfolio(portfolioId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(service.getByProject(projectId));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UrlRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UrlRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
