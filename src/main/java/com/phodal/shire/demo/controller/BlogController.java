package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.dto.CreateBlogRequest;
import com.phodal.shire.demo.dto.CreateBlogResponse;
import com.phodal.shire.demo.entity.BlogPost;
import com.phodal.shire.demo.service.BlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {
    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @ApiOperation(value = "Get Blog by id")
    @GetMapping("/{id}")
    public BlogPost getBlog(@PathVariable Long id) {
        return blogService.getBlogPostById(id);
    }

    @ApiOperation(value = "Create a new blog")
    @PostMapping("/")
    public BlogPost cftBlog(@RequestBody CreateBlogRequest request) {
        CreateBlogResponse response = new CreateBlogResponse();
        BlogPost blogPost = new BlogPost();
        BeanUtils.copyProperties(request, blogPost);
        BlogPost createdBlog = blogService.createBlog(blogPost);
        BeanUtils.copyProperties(createdBlog, response);
        return createdBlog;
    }
}