package com.petproject.taskmanagerapi.taskmanagment.service;

import com.petproject.taskmanagerapi.taskmanagment.model.Task;
import com.petproject.taskmanagerapi.taskmanagment.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
