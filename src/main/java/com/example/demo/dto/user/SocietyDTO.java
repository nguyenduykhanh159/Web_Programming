package com.example.demo.dto.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SocietyDTO extends UserDTO{
    @JsonProperty("industry_code")
    private String industryCode;

    @JsonProperty("established_date")
    private Date establishedDate;

    @JsonProperty("total_capital")
    private float totalCapital;
}
