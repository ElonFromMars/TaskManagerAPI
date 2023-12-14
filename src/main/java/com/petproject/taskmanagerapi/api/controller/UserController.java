package com.petproject.taskmanagerapi.api.controller;

import com.petproject.taskmanagerapi.api.model.User;
import com.petproject.taskmanagerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/user")
    public User getUser(/*@RequestParam int id*/){
        Optional<User> user = userService.getUser(0);
        return user.orElse(null);

    }
}
