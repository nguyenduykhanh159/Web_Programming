package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class FarmerDTO extends UserDTO {
    @JsonProperty("age")
    private int age;
}
