package com.example.managementproject.web.controller;

import com.example.managementproject.model.User;
import com.example.managementproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        System.out.println("username" + user);
        return userService.registerUser(user.getUsername(), user.getPassword());
    }
}
