package com.example.demo.service.user;

import com.example.demo.dto.user.SocietyDTO;


public interface SocietyService extends UserService<SocietyDTO> {
    boolean addSocietyToFarmer(int societyid,int farmerid);
}
