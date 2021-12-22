package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JobDTO {
    @JsonProperty("description")
    private String description;

    @JsonProperty("due")
    private Date due;

    @JsonProperty("fee")
    private float fee;

    @JsonProperty("name")
    private String name;
}
