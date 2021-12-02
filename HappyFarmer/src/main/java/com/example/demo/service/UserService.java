package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserModel;

import org.springframework.stereotype.Service;
public interface UserService {
    public List<UserModel> getAllUsers();
    public UserModel getUser(int userId);
    public void addUser(UserModel user);
}
