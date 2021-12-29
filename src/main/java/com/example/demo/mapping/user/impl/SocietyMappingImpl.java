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

        UserDTO society = UserDTO.builder()
                .name(user.getName())
                .address(user.getAddress())
                .username(user.getUsername())
                .password(user.getPassword())
                .phone(user.getPhone())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .totalCapital(user.getTotalCapital())
                .establishedDate(user.getEstablishedDate())
                .industryCode(user.getIndustryCode())
                .build();
        return society;
    }

}
