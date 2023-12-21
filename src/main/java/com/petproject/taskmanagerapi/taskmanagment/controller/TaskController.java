package com.petproject.taskmanagerapi.taskmanagment.controller;

import com.petproject.taskmanagerapi.taskmanagment.model.Task;
import com.petproject.taskmanagerapi.taskmanagment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping("/tasks")
    List<Task> getAll() {
        return taskService.findAll();
    }
}
