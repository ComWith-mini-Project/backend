package com.mini_project.mini_project.activity.controller;

import com.mini_project.mini_project.activity.Service.ActivityService;
import com.mini_project.mini_project.activity.dto.ActivityRequestDto;
import com.mini_project.mini_project.activity.entity.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/career/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(activityService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ActivityRequestDto dto) {
        Activity activity = activityService.create(dto);

        return ResponseEntity.ok(
                Map.of("message", dto.getType() == Activity.ActivityType.AWARD ? "수상 내역이 등록되었습니다." : "활동이 등록되었습니다.",
                        "activity_id", activity.getId())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ActivityRequestDto dto) {
        return ResponseEntity.ok(activityService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        activityService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
