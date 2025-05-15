package com.mini_project.mini_project.activity.dto;

import com.mini_project.mini_project.activity.entity.Activity;
import lombok.Data;

@Data
public class ActivityRequestDto {

    private Activity.ActivityType type;
    private String title;
    private String organization;
    private String startDate;
    private String endDate;
    private boolean inProgress;
    private String description;

}
