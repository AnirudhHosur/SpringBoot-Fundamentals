package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    IRepository repository;

    public List<Blog> getAllBlogs() {
        return repository.findAll();
    }

    public String saveBlog(Blog blog) {
        repository.save(blog);
        return "Blog Saved";
    }

    public Optional<Blog> getBlogById(int id) {
        return repository.findById(id);
    }
}
