package com.mini_project.mini_project.activity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityType type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String organization;

    @Column(nullable = false)
    private String startDate;

    private String endDate;
    private boolean inProgress;  // 활동 중 여부 (수상은 항상 false로 설정)

    private String description;

    public enum ActivityType {
        AWARD,
        ACTIVITY
    }
}
