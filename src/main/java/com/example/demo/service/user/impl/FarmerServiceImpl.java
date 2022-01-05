package com.example.demo.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dao.FarmerRepository;
import com.example.demo.dao.FarmerSocietyRepository;
import com.example.demo.dao.SocietyRepository;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.user.Farmer;
import com.example.demo.entity.user.FarmerSociety;
import com.example.demo.entity.user.FarmerSocietyID;
import com.example.demo.entity.user.Society;
import com.example.demo.mapping.user.UserMapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private FarmerSocietyRepository fsRepository;

    @Autowired
    private UserMapping<Farmer, UserDTO> farmerMapping;

    
    public List<UserDTO> getAll() {

        List<Farmer> farmers = farmerRepository.findAll();
        // TODO Auto-generated method stub
        return farmers.stream().map(farmer -> farmerMapping.mapUserToUserDto(farmer)).collect(Collectors.toList());
    }

   
    public UserDTO getUser(int userId) {
        // TODO Auto-generated method stub
        Farmer farmer = farmerRepository.getById(userId);

        return farmerMapping.mapUserToUserDto(farmer);
    }

   
    public BaseResponse addUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        try {
            Farmer farmer = farmerMapping.mapUserDtoToUser(userDTO);
            farmerRepository.save(farmer);

            userDTO.setCreatedAt(farmer.getCreatedAt());
            return new BaseResponse<>(HttpStatus.OK, "Register Successful!",userDTO);
        } catch (Exception e) {
            
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Register failed!");
        }

        
    }

   
    public boolean removeUser(int userId) {
        // TODO Auto-generated method stub

        try {
            farmerRepository.deleteById(userId);
            return true;
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return false;

    }

    public boolean addFarmerToSociety(int userid, int societyid) {
        try {
            Farmer farmer = farmerRepository.getById(userid);
            Society society = societyRepository.getById(societyid);
            FarmerSociety new_fs = new FarmerSociety();
            FarmerSocietyID fsID = new FarmerSocietyID(userid, societyid);
            new_fs.setFarmerSocietyID(fsID);
            new_fs.setFarmer(farmer);
            new_fs.setSociety(society);
            new_fs.setJoinedDate(new Date());
            fsRepository.save(new_fs);
            return true;

        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;

    }

}
