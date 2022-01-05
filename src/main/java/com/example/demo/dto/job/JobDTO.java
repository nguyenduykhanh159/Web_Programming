package com.example.demo.dto.job;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobDTO {
    
    @JsonProperty("id")
    private int id;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("username")
    private String username;

    @JsonProperty("contact_number")
    private String contactNumber;

    @JsonProperty("due")
    private Date due;

    @JsonProperty("salary")
    private Float salary;

    @JsonProperty("name")
    private String name;

    @JsonProperty("job_detail")
    private String jobDetail;

    @JsonProperty("area")
    private Float area;

    @JsonProperty("status")    
    private String jobStatus;

    @JsonProperty("request_status")
    private String requestStatus;
}
