package com.example.demo.dao;

import com.example.demo.entity.user.Farmer;
import com.example.demo.entity.user.Society;
import com.example.demo.entity.user.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int userid);
    Farmer getFarmerById(int farmerid);
    Society getSocietyById(int societyid);
}