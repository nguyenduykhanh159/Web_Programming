package com.example.demo.dto.job;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JobDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("create_At")
    private Date create_At;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("contact_number")
    private String contact_number;

    @JsonProperty("due")
    private Date due;

    @JsonProperty("salary")
    private float salary;

    @JsonProperty("name")
    private String name;

    @JsonProperty("job_detail")
    private String job_detail;
}
