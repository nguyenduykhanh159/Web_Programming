package com.example.demo.dto.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SocietyDTO extends UserDTO{
    @JsonProperty("industry_code")
    private String industry_code;
    @JsonProperty("established_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate established_date;
    @JsonProperty("total_capital")
    private Float total_capital;
}
