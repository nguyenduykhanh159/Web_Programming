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
public class SocietyServiceImpl  {

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmerSocietyRepository fsRepository;

    @Autowired
    private UserMapping<Society, UserDTO> societyMapping;

  
    public List<UserDTO> getAll() {

        List<Society> societies = societyRepository.findAll();
        return societies.stream().map(society -> societyMapping.mapUserToUserDto(society)).collect(Collectors.toList());
    }

  
    public UserDTO getUser(int userId) {

        Society society = societyRepository.getById(userId);
        return societyMapping.mapUserToUserDto(society);
    }

   
    public BaseResponse addUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        try
        {
            Society society = societyMapping.mapUserDtoToUser(userDTO);
            societyRepository.save(society) ;

            userDTO.setCreatedAt(society.getCreatedAt());
            return new BaseResponse<>(HttpStatus.OK, "Register successful!",userDTO);
        }catch(Exception ex)
        {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Register failed!");
        }
        
        
    }

  
    public boolean removeUser(int userId) {
        try {
            societyRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

  
    public boolean addSocietyToFarmer(int societyid, int farmerid) {
        try {
            Farmer farmer = farmerRepository.getById(farmerid);
            Society society = societyRepository.getById(societyid);
            FarmerSociety new_fs = new FarmerSociety();
            FarmerSocietyID fsID = new FarmerSocietyID(farmerid, societyid);
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
