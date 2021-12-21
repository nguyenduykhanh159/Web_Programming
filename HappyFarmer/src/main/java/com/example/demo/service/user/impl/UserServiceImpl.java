package com.example.demo.service.user.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.entity.Farmer;
import com.example.demo.entity.Society;
import com.example.demo.entity.User;
import com.example.demo.mapping.user.UserMapping;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapping userMapping;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // @Override
    // public UserDetails loadUserByUsername(String username) throws
    // UsernameNotFoundException {
    // // TODO Auto-generated method stub
    // return null;
    // }

    @Override
    public User getUser(int userId) {
        // TODO Auto-generated method stub
        return userRepository.getById(userId);
    }

    @Override
    public boolean addFarmerUser(FarmerDTO farmerDTO) {

        Farmer farmer = userMapping.mapFarmerDtoToFarmer(farmerDTO);
        if (userRepository.save(farmer) != null) {
            return true;
        }
        ;
        return false;

    }

    @Override
    public boolean addSocietyUser(SocietyDTO societyDTO) {

        Society society = userMapping.mapSocietyDtoToSociety(societyDTO);
        if (userRepository.save(society) != null) {
            return true;
        }
        return false;

    }

    @Override
    @Transactional
    public boolean addUserToSociety(int userId, int societyId) {
        // TODO Auto-generated method stub

        try {
            Farmer farmer = (Farmer) userRepository.getById(userId);
            Society society = (Society) userRepository.getById(societyId);

            farmer.setSocieties(Set.copyOf(Arrays.asList(society)));
            society.setFarmers(Set.copyOf(Arrays.asList(farmer)));
            userRepository.save(farmer);
            userRepository.save(society);
            return true;
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return false;
    }

}
