package com.example.demo.mapping.user;

import com.example.demo.entity.Farmer;
import com.example.demo.entity.Society;
import com.example.demo.entity.User;

public interface UserMappingInheritance {
    Farmer mapUserToFarmer(User user);
    Society mapUserToSociety(User user);
}
