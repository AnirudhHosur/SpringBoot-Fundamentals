package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class BlogControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BlogService blogService;

    @InjectMocks
    private BlogController blogController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(blogController).build();
    }

    @Test
    void getAllBlogsTestSHouldReturnAllBlogs() throws Exception {
        Blog blog = new Blog(1, "Test content");
        List<Blog> blogs = List.of(blog);

        given(blogService.getAllBlogs()).willReturn(blogs);

        mockMvc.perform(get("/blogs"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1, 'content': 'Test content'}]"));
    }

    @Test
    void saveBlogTestShouldReturnSaved() throws Exception {
        Blog blog = new Blog(2, "Another test content");
        given(blogService.saveBlog(blog)).willReturn("Blog Saved");

        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 2, \"content\": \"Another test content\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Blog Saved"));
    }
}