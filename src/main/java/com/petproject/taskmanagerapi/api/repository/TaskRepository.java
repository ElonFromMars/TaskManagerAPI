package com.petproject.taskmanagerapi.api.repository;

import com.petproject.taskmanagerapi.api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Integer> {
}
