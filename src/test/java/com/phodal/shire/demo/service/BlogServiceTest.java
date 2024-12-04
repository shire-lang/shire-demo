package com.phodal.shire.demo.service;

import com.phodal.shire.demo.entity.BlogPost;
import com.phodal.shire.demo.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @Test
    void shouldCreateBlog() {
        // Given
        BlogPost blogPost = new BlogPost("Title", "Content", "Author");
        when(blogRepository.save(any(BlogPost.class))).thenReturn(blogPost);

        // When
        BlogPost createdBlog = blogService.createBlog(blogPost);

        // Then
        assertThat(createdBlog).isNotNull();
        assertThat(createdBlog.getTitle()).isEqualTo("Title");
        verify(blogRepository).save(any(BlogPost.class));
    }

    @Test
    void shouldGetBlogPostById() {
        // Given
        Long id = 1L;
        BlogPost blogPost = new BlogPost("Title", "Content", "Author");
        when(blogRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(blogPost));

        // When
        BlogPost foundBlog = blogService.getBlogPostById(id);

        // Then
        assertThat(foundBlog).isNotNull();
        assertThat(foundBlog.getTitle()).isEqualTo("Title");
        verify(blogRepository).findById(id);
    }

    @Test
    void shouldUpdatePost() {
        // Given
        Long id = 1L;
        BlogPost existingPost = new BlogPost("Old Title", "Old Content", "Author");
        BlogPost updatedPost = new BlogPost("New Title", "New Content", "Author");
        when(blogRepository.findById(id)).thenReturn(java.util.Optional.of(existingPost));
        when(blogRepository.save(any(BlogPost.class))).thenReturn(updatedPost);

        // When
        BlogPost result = blogService.updatePost(id, updatedPost);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("New Title");
        verify(blogRepository).findById(id);
        verify(blogRepository).save(existingPost);
    }

    @Test
    void shouldDeleteBlog() {
        // Given
        Long id = 1L;
        willDoNothing().given(blogRepository).deleteById(id);

        // When
        blogService.deleteBlog(id);

        // Then
        verify(blogRepository).deleteById(id);
    }
}
