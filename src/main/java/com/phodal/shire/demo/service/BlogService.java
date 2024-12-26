package com.phodal.shire.demo.service;

import com.phodal.shire.demo.entity.BlogPost;
import com.phodal.shire.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public BlogPost createBlog(BlogPost blogDto) {
        return blogRepository.save(blogDto);
    }

    public BlogPost getBlogPostById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public BlogPost updatePost(Long id, BlogPost blogDto) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(blogDto.getTitle());
            blog.setContent(blogDto.getContent());
            return blogRepository.save(blog);
        }).orElse(null);
    }
}
