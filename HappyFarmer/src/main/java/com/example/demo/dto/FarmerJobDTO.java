package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FarmerJobDTO {
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
