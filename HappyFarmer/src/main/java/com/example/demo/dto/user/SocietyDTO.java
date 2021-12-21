package com.example.demo.dto.user;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SocietyDTO extends UserDTO{
    @JsonProperty("industry_code")
    private String industry_code;
    @JsonProperty("established_date")
    private Date established_date;
    @JsonProperty("total_capital")
    private Float total_capital;
}
