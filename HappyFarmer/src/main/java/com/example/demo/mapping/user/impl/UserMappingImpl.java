package com.example.demo.mapping.user.impl;

import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.Farmer;
import com.example.demo.entity.Society;
import com.example.demo.entity.User;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.stereotype.Component;

@Component
public class UserMappingImpl implements UserMapping {
    public User mapUserDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    @Override
    public Farmer mapFarmerDtoToFarmer(FarmerDTO farmerDTO) {
        Farmer farmer = new Farmer();
        farmer.setName(farmerDTO.getName());
        farmer.setAddress(farmerDTO.getAddress());
        farmer.setUsername(farmerDTO.getUsername());
        farmer.setPassword(farmerDTO.getPassword());
        farmer.setPhone(farmerDTO.getPhone());
        farmer.setEmail(farmerDTO.getEmail());
        farmer.setAge(farmerDTO.getAge());
        return farmer;
    }

    @Override
    public Society mapSocietyDtoToSociety(SocietyDTO societyDTO) {
        Society society =new Society();
        society.setName(societyDTO.getName());
        society.setAddress(societyDTO.getAddress());
        society.setUsername(societyDTO.getUsername());
        society.setPassword(societyDTO.getPassword());
        society.setPhone(societyDTO.getPhone());
        society.setEmail(societyDTO.getEmail());
        society.setEstablishesDate(societyDTO.getEstablished_date());
        society.setIndustryCode(societyDTO.getIndustry_code());
        society.setTotalCapital(societyDTO.getTotal_capital());
        return society;
    }
}
