package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapping.user.UserMapping;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapping userMapping;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    @Override
    public User getUser(int userId) {
        // TODO Auto-generated method stub
        return userRepository.getById(userId);
    }


    @Override
    public void addFarmerUser(UserDTO user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addSocietyUser(UserDTO user) {
        // TODO Auto-generated method stub
        
    }
    
}
