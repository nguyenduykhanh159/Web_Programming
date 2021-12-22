package com.example.demo.service.user;

import com.example.demo.dto.user.FarmerDTO;


public interface FarmerService extends UserService<FarmerDTO> {
    boolean addFarmerToSociety(int userid,int societyid);
}
