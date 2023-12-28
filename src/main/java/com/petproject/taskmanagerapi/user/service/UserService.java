package com.petproject.taskmanagerapi.user.service;

import com.petproject.taskmanagerapi.user.model.User;
import com.petproject.taskmanagerapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
