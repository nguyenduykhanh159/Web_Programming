package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(int userId);
    public void addFarmerUser(UserDTO user);
    public void addSocietyUser(UserDTO user);
    
}
