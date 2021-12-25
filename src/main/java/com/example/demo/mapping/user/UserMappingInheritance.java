package com.example.demo.mapping.user;

import com.example.demo.entity.user.Farmer;
import com.example.demo.entity.user.Society;
import com.example.demo.entity.user.User;

public interface UserMappingInheritance {
    Farmer mapUserToFarmer(User user);
    Society mapUserToSociety(User user);
}
