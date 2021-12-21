package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer userId)
    {
        return userService.getUser(userId);
    }

    public void addUser(User user)
    {
        userService.addUser(user);
    }
    
}
