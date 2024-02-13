package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    ITaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public String saveTask(Task task) {
        taskRepository.save(task);
        return "Tasked saved";
    }
}
