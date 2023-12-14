package com.petproject.taskmanagerapi.api.service;

import com.petproject.taskmanagerapi.api.model.User;
import com.petproject.taskmanagerapi.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(Long id) {

        return Optional.of(userRepository.getReferenceById(id));
    }
}
