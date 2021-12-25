package com.example.demo.mapping.user.impl;

import java.util.Date;

import com.example.demo.dto.auth.RegisterDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.user.User;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMappingIml implements UserMapping<User,RegisterDTO> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User mapUserDtoToUser(RegisterDTO userDTO) {
        
        User user=new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setCreatedAt(new Date());
        user.setPhone(user.getPhone());
        return user;
    }

    @Override
    public RegisterDTO mapUserToUserDto(User user) {
        
        RegisterDTO registerDTO=new RegisterDTO();
        registerDTO.setName(user.getName());
        registerDTO.setUsername(user.getUsername());
        registerDTO.setPassword(user.getPassword());
        registerDTO.setEmail(user.getEmail());
        registerDTO.setAddress(user.getAddress());
        registerDTO.setPhone(user.getPhone());
        registerDTO.setCreatedAt(user.getCreatedAt());

        return registerDTO;
    }
    
}
