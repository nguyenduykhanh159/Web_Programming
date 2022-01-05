package com.example.demo.mapping.user.impl;
import java.util.Date;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.user.Farmer;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.stereotype.Component;

@Component
public class FarmerMappingImpl implements UserMapping<Farmer,UserDTO>  {


    @Override
    public Farmer mapUserDtoToUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        Farmer farmer = new Farmer();
        farmer.setName(userDTO.getName());
        farmer.setAddress(userDTO.getAddress());
        farmer.setUsername(userDTO.getUsername());
        farmer.setPassword(userDTO.getPassword());
        farmer.setPhone(userDTO.getPhone());
        farmer.setEmail(userDTO.getEmail());
        farmer.setImageUrl(userDTO.getImageUrl());
        farmer.setDateOfBirth(userDTO.getDateOfBirth());
        farmer.setCreatedAt(userDTO.getCreatedAt()!=null?userDTO.getCreatedAt():new Date());
        return farmer;
    }

    @Override
    public UserDTO mapUserToUserDto(Farmer user) {
         UserDTO farmer = new UserDTO();
        farmer.setName(user.getName());
        farmer.setAddress(user.getAddress());
        farmer.setUsername(user.getUsername());
        farmer.setPassword(user.getPassword());
        farmer.setPhone(user.getPhone());
        farmer.setEmail(user.getEmail());
        farmer.setAge(user.getAge()); 
        farmer.setImageUrl(user.getImageUrl());
        farmer.setDateOfBirth(user.getDateOfBirth());
        return farmer;
    }

    
}
