package com.example.demo.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dao.FarmerRepository;
import com.example.demo.dao.FarmerSocietyRepository;
import com.example.demo.dao.SocietyRepository;
import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.entity.Farmer;
import com.example.demo.entity.FarmerSociety;
import com.example.demo.entity.FarmerSocietyID;
import com.example.demo.entity.Society;
import com.example.demo.mapping.user.UserMapping;
import com.example.demo.service.user.SocietyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocietyServiceImpl implements SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmerSocietyRepository fsRepository;

    @Autowired
    private UserMapping<Society, SocietyDTO> societyMapping;

    @Override
    public List<SocietyDTO> getAll() {

        List<Society> societies = societyRepository.findAll();
        return societies.stream().map(society -> societyMapping.mapUserToUserDto(society)).collect(Collectors.toList());
    }

    @Override
    public SocietyDTO getUser(int userId) {

        Society society = societyRepository.getById(userId);
        return societyMapping.mapUserToUserDto(society);
    }

    @Override
    public boolean addUser(SocietyDTO userDTO) {
        // TODO Auto-generated method stub
        Society society = societyMapping.mapUserDtoToUser(userDTO);
        if (societyRepository.save(society) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeUser(int userId) {
        try {
            societyRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
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
