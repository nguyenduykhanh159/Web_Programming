package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final MockDataRepo dataRepo;
   
    @Autowired
    public UserServiceImpl(@Qualifier("mockData")MockDataRepo dataRepo)
    {
        this.dataRepo=dataRepo;
    }
    @Override
    public List<UserModel> getAllUsers() {
        // TODO Auto-generated method stub
        return dataRepo.getAllUsers();
    }
    
    @Override
    public UserModel getUser(int userId) {
        // TODO Auto-generated method stub
        return dataRepo.getUser(userId);
    }

    @Override
    public void addUser(UserModel user) {
        // TODO Auto-generated method stub
        dataRepo.addUser(user);
        
    }
    
}
