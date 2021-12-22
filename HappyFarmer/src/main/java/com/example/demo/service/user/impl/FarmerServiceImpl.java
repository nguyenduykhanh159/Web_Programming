package com.example.demo.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dao.FarmerRepository;
import com.example.demo.dao.FarmerSocietyRepository;
import com.example.demo.dao.SocietyRepository;
import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.entity.Farmer;
import com.example.demo.entity.FarmerSociety;
import com.example.demo.entity.FarmerSocietyID;
import com.example.demo.entity.Society;
import com.example.demo.mapping.user.UserMapping;
import com.example.demo.service.user.FarmerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl implements FarmerService{

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private FarmerSocietyRepository fsRepository;

    @Autowired 
    private UserMapping<Farmer,FarmerDTO> farmerMapping;

    @Override
    public List<FarmerDTO> getAll() {

        List<Farmer> farmers=farmerRepository.findAll();
        // TODO Auto-generated method stub
        return farmers.stream().map(farmer->farmerMapping.mapUserToUserDto(farmer)).collect(Collectors.toList());
    }

    @Override
    public FarmerDTO getUser(int userId) {
        // TODO Auto-generated method stub
        Farmer farmer=farmerRepository.getById(userId);

        return farmerMapping.mapUserToUserDto(farmer);
    }

    @Override
    public boolean addUser(FarmerDTO userDTO) {
        // TODO Auto-generated method stub
        Farmer farmer =farmerMapping.mapUserDtoToUser(userDTO);
        if(farmerRepository.save(farmer)!=null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeUser(int userId) {
        // TODO Auto-generated method stub

        try
        {
            farmerRepository.deleteById(userId);
            return true;
        }catch(Exception ex)
        {
            ex.getStackTrace();
        }
        return false;
        
    }
  
    public boolean addFarmerToSociety(int userid,int societyid)
    {
        try {
              Farmer farmer=farmerRepository.getById(userid);
              Society society=societyRepository.getById(societyid);
              FarmerSociety new_fs=new FarmerSociety();
              FarmerSocietyID fsID=new FarmerSocietyID(userid,societyid);
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
