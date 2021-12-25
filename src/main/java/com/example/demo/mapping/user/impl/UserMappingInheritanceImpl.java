package com.example.demo.mapping.user.impl;


import com.example.demo.mapping.user.UserMappingInheritance;

import org.springframework.stereotype.Component;

@Component
public class UserMappingInheritanceImpl implements UserMappingInheritance {

    @Override
    public Farmer mapUserToFarmer(User user) {

        Farmer farmer = new Farmer();
        farmer.setId(user.getId());
        farmer.setCreatedAt(user.getCreatedAt());
        farmer.setAddress(user.getAddress());
        farmer.setEmail(user.getEmail());
        farmer.setUsername(user.getUsername());
        farmer.setPassword(user.getPassword());
        farmer.setName(user.getName());
        farmer.setPhone(user.getPhone());
        farmer.setAuthorities(user.getAuthorities());
        farmer.setOrders(user.getOrders());
        return farmer;
    }

    @Override
    public Society mapUserToSociety(User user) {
        Society society = new Society();
        society.setId(user.getId());
        society.setCreatedAt(user.getCreatedAt());
        society.setAddress(user.getAddress());
        society.setEmail(user.getEmail());
        society.setUsername(user.getUsername());
        society.setPassword(user.getPassword());
        society.setName(user.getName());
        society.setPhone(user.getPhone());
        society.setAuthorities(user.getAuthorities());
        society.setOrders(user.getOrders());
        return society;
    }
}
