package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.UserModel;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmerController {
    public List<UserModel> getAllUsers()
    {
        return new ArrayList<UserModel>();
    }
    public UserModel getUser(int userId)
    {
        return new UserModel();
    }
    
}
