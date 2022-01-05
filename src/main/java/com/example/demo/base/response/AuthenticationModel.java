package com.example.demo.base.response;

import com.example.demo.dto.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthenticationModel {

    @JsonProperty("token")
    private String token;
    
    @JsonProperty("user")
    private UserDTO user;
}
