package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FarmerSocietyDTO {

   @JsonProperty("user_name")
   private String user_name;
   @JsonProperty("society_name")
   private String society_name;
   
}
