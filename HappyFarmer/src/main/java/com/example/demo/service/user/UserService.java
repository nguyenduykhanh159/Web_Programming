package com.example.demo.service.user;

import java.util.List;

import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.dto.user.FarmerSocietyDTO;
import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.entity.User;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(int userId);
    public boolean addFarmerUser(FarmerDTO farmerDTO);
    public boolean addSocietyUser(SocietyDTO societyDTO);
    public boolean addUserToSociety(int userId,int societyId);
    
}