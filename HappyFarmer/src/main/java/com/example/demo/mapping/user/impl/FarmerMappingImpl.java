package com.example.demo.mapping.user.impl;

import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.entity.Farmer;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.stereotype.Component;

@Component
public class FarmerMappingImpl implements UserMapping<Farmer,FarmerDTO>  {

    @Override
    public Farmer mapUserDtoToUser(FarmerDTO userDTO) {
        // TODO Auto-generated method stub
        Farmer farmer = new Farmer();
        farmer.setName(userDTO.getName());
        farmer.setAddress(userDTO.getAddress());
        farmer.setUsername(userDTO.getUsername());
        farmer.setPassword(userDTO.getPassword());
        farmer.setPhone(userDTO.getPhone());
        farmer.setEmail(userDTO.getEmail());
        farmer.setAge(userDTO.getAge());
        return farmer;
    }

    @Override
    public FarmerDTO mapUserToUserDto(Farmer user) {
       FarmerDTO farmer = new FarmerDTO();
        farmer.setName(user.getName());
        farmer.setAddress(user.getAddress());
        farmer.setUsername(user.getUsername());
        farmer.setPassword(user.getPassword());
        farmer.setPhone(user.getPhone());
        farmer.setEmail(user.getEmail());
        farmer.setAge(user.getAge()); 
        return farmer;
    }

    
}
