package com.example.demo.service.user;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.user.UserDTO;

public interface UserService {

    BaseResponse getAllUsers();
    BaseResponse registerUser(UserDTO userDTO);
    BaseResponse removeUser(int userId);
    BaseResponse login(UserDTO userDTO);
    BaseResponse updateProfile(UserDTO userDTO);
    BaseResponse profile(); 
}
