package com.petproject.taskmanagerapi.api.controller;

import com.petproject.taskmanagerapi.api.model.User;
import com.petproject.taskmanagerapi.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        Optional<User> user = userService.getUser(id);
        return user.orElse(null);
    }
}
