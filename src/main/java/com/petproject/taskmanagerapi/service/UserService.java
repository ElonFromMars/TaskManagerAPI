package com.petproject.taskmanagerapi.service;

import com.petproject.taskmanagerapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user = new User(1, "Ivan", "ivan@gmail.com");
        User user2 = new User(2, "Kalywan", "kalywan@gmail.com");
        User user3 = new User(1, "Evlampij", "ewlampij228@gmail.com");

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
    }

    public Optional<User> getUser(int id) {

        return Optional.of(userList.get(id));
    }
}
