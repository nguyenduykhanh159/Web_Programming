package com.example.demo.base.response.auth;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthBody {
   
        @JsonProperty("username")
        private String username;

        @JsonProperty("token")
        private String token;

        @JsonProperty("at")
        private Date at; 
}
