package com.petproject.taskmanagerapi.user.controller;

import com.petproject.taskmanagerapi.user.exception.ResourceNotFoundException;
import com.petproject.taskmanagerapi.user.model.User;
import com.petproject.taskmanagerapi.user.repository.UserRepository;
import com.petproject.taskmanagerapi.user.security.CurrentUser;
import com.petproject.taskmanagerapi.user.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        return user;
    }

    //TODO remove
    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User getUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
