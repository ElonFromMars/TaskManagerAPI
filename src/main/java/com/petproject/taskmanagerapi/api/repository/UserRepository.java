package com.petproject.taskmanagerapi.api.repository;

import com.petproject.taskmanagerapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
