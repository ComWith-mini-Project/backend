package com.mini_project.mini_project.url.dto;

import lombok.Data;

@Data
public class UrlRequestDto {
    private Long memberId;
    private Long portfolioId;
    private Long projectId;
    private String platform;
    private String url;
}
