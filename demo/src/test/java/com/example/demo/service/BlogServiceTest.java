package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.repository.IRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class BlogServiceTest {

    @Mock
    IRepository repository;

    @InjectMocks
    private BlogService blogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBlogsTest() {
        Blog blog = new Blog(1, "Test content");
        List<Blog> expectedBlogs = List.of(blog);
        given(repository.findAll()).willReturn(expectedBlogs);

        List<Blog> actualBlogs = blogService.getAllBlogs();

        assertEquals(expectedBlogs, actualBlogs);
    }
}
