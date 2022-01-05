package com.example.demo.mapping.user.impl;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.user.Society;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.stereotype.Component;

@Component
public class SocietyMappingImpl implements UserMapping<Society, UserDTO> {

    @Override
    public Society mapUserDtoToUser(UserDTO userDTO) {

        Society society = new Society();
        society.setName(userDTO.getName());
        society.setAddress(userDTO.getAddress());
        society.setUsername(userDTO.getUsername());
        society.setPassword(userDTO.getPassword());
        society.setPhone(userDTO.getPhone());
        society.setEmail(userDTO.getEmail());
        society.setEstablishedDate(userDTO.getEstablishedDate());
        society.setIndustryCode(userDTO.getIndustryCode());
        society.setTotalCapital(userDTO.getTotalCapital());
        return society;
    }

    @Override
    public UserDTO mapUserToUserDto(Society user) {

        UserDTO society = new UserDTO();
        society.setName(user.getName());
        society.setAddress(user.getAddress());
        society.setUsername(user.getUsername());
        society.setPassword(user.getPassword());
        society.setPhone(user.getPhone());
        society.setEmail(user.getEmail());
        society.setEstablishedDate(user.getEstablishedDate());
        society.setIndustryCode(user.getIndustryCode());
        society.setTotalCapital(user.getTotalCapital());
        return society;
    }

}
