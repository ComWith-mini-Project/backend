package com.mini_project.mini_project.activity.Service;

import com.mini_project.mini_project.activity.dto.ActivityRequestDto;
import com.mini_project.mini_project.activity.entity.Activity;
import com.mini_project.mini_project.activity.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    public Activity create(ActivityRequestDto dto) {
        Activity activity = Activity.builder()
                .type(dto.getType())
                .title(dto.getTitle())
                .organization(dto.getOrganization())
                .startDate(dto.getStartDate())
                .endDate(dto.isInProgress() ? null : dto.getEndDate())
                .inProgress(dto.isInProgress())
                .description(dto.getDescription())
                .build();

        return activityRepository.save(activity);
    }

    public Activity update(Long id, ActivityRequestDto dto) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("활동 또는 수상 정보를 찾을 수 없습니다."));

        activity.setType(dto.getType());
        activity.setTitle(dto.getTitle());
        activity.setOrganization(dto.getOrganization());
        activity.setStartDate(dto.getStartDate());
        activity.setEndDate(dto.isInProgress() ? null : dto.getEndDate());
        activity.setInProgress(dto.isInProgress());
        activity.setDescription(dto.getDescription());

        return activityRepository.save(activity);
    }

    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
