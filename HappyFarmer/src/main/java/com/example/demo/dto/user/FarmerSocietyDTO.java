package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FarmerSocietyDTO {

   @JsonProperty("username")
   private String user_name;
   @JsonProperty("so")
   private String society_name;
   
}
