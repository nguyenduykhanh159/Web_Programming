package com.example.demo.mapping.user;

import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.Farmer;
import com.example.demo.entity.Society;
import com.example.demo.entity.User;

public interface UserMapping{
   User mapUserDtoToUser(UserDTO userDTO);
   Farmer mapFarmerDtoToFarmer(FarmerDTO farmerDTO);
   Society mapSocietyDtoToSociety(SocietyDTO societyDTO);
}
