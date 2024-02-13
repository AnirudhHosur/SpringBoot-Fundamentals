package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping("/save")
    public String saveBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
    }
}
