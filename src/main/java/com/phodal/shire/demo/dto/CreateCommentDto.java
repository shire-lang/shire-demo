package com.phodal.shire.demo.dto;

import lombok.Data;

@Data
public class CreateCommentDto {
    private String title;
    private String content;
    private String author;
}
