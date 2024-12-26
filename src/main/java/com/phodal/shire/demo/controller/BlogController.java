package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.dto.CreateBlogRequest;
import com.phodal.shire.demo.dto.DeleteBlogResponse;
import com.phodal.shire.demo.dto.CreateBlogResponse;
import com.phodal.shire.demo.entity.BlogPost;
import com.phodal.shire.demo.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Hello
 *
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * Get Blog by id
     *
     * @param id The id of the blog post to retrieve
     * @return The blog post with the specified id
     */
    @GetMapping("/{id}")
    public BlogPost getBlog(@PathVariable Long id) {
        return blogService.getBlogPostById(id);
    }

    /**
     * Create a new blog post by receiving a request with blog post details.
     *
     * @param request The request object containing the details of the blog post to be created
     * @return The newly created blog post
     */
    @PostMapping("/")
    public BlogPost cftBlog(@RequestBody CreateBlogRequest request) {
        CreateBlogResponse response = new CreateBlogResponse();
        BlogPost blogPost = new BlogPost();
        BeanUtils.copyProperties(request, blogPost);
        BlogPost createdBlog = blogService.createBlog(blogPost);
        BeanUtils.copyProperties(createdBlog, response);
        return createdBlog;
    }

    /**
     * Delete a blog post by id.
     *
     * @param id The id of the blog post to delete
     * @return A response indicating the blog post was deleted
     */
    @DeleteMapping("/{id}")
    public DeleteBlogResponse deleteBlog(@PathVariable Long id) {
        return blogService.deleteBlog(id);
    }
}