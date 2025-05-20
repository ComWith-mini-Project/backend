package com.mini_project.mini_project.url.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId; // 기본 페이지에서도 사용

    private Long portfolioId; // 포트폴리오 페이지에서도 사용

    private Long projectId; // 프로젝트 페이지에서도 사용

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false, length = 255)
    private String url;
}
