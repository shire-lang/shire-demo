package com.phodal.shire.demo.dto;

import lombok.Data;

@Data
public class CreateBlogResponse {
    private Long id;
    private String title;
    private String content;
}