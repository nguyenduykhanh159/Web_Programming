package com.example.demo.dto.workplace;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WorkplaceDTO {
    
    @JsonProperty("address")
    private String address;

    @JsonProperty("area")
    private float area;

    @JsonProperty("type_work")
    private String type_work;
}
