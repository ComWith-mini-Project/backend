package com.mini_project.mini_project.education.controller;

import com.mini_project.mini_project.education.dto.EducationRequestDto;
import com.mini_project.mini_project.education.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(educationService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EducationRequestDto dto) {
        return ResponseEntity.ok(educationService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EducationRequestDto dto) {
        return ResponseEntity.ok(educationService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
