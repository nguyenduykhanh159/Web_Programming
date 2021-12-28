package com.example.demo.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginDTO {
    
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
