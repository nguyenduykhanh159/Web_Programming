package com.example.demo.controller.user;

import java.util.List;
import java.util.stream.Collectors;


import com.example.demo.entity.Farmer;
import com.example.demo.entity.Society;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/farmer")
    public List<Farmer> getAllFarmers() {
        List<User> users = userService.getAllUsers();
        return users.stream().filter(user -> user.getClass() == Farmer.class).map(user -> (Farmer) user)
                .collect(Collectors.toList());
    }

    @GetMapping("/society")
    public List<Society> getAllSocieties() {
        List<User> users = userService.getAllUsers();
        return users.stream().filter(user -> user.getClass() == Society.class).map(user -> (Society) user)
                .collect(Collectors.toList());
    }

}
