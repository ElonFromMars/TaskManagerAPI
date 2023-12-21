package com.petproject.taskmanagerapi.taskmanagment.repository;

import com.petproject.taskmanagerapi.taskmanagment.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Integer> {
}
