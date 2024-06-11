package com.phodal.shire.demo.dto;

import com.phodal.shire.demo.entity.Author;
import lombok.Data;

@Data
public class CreateBlogRequest {
    private String title;
    private String content;
    private Author author;
}