package com.petproject.taskmanagerapi.api.service;

import com.petproject.taskmanagerapi.api.model.Task;
import com.petproject.taskmanagerapi.api.model.User;
import com.petproject.taskmanagerapi.api.repository.TaskRepository;
import com.petproject.taskmanagerapi.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
