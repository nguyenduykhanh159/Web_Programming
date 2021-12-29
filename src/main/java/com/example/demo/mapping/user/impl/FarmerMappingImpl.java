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
        farmer.setAge(userDTO.getAge());
        farmer.setCreatedAt(userDTO.getCreatedAt()!=null?userDTO.getCreatedAt():new Date());
        return farmer;
    }

    @Override
    public UserDTO mapUserToUserDto(Farmer user) {
       UserDTO farmer = UserDTO.builder()
        .name(user.getName())
        .address(user.getAddress())
        .username(user.getUsername())
        .password(user.getPassword())
        .phone(user.getPhone())
        .email(user.getEmail())
        .age(user.getAge())
        .createdAt(user.getCreatedAt())
        .build();

        return farmer;
    }

    
}
