package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SocietyDTO {
    @JsonProperty("established_date")
    private Date established_date;
    
    @JsonProperty("industry_code")
    private String industry_code;

    @JsonProperty
    private float total_capital;
}
