package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @GetMapping("")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable("id") Integer userId)
    {
        return userService.getUser(userId);
    }

    public void addUser(UserModel user)
    {
        userService.addUser(user);
    }
    
}
