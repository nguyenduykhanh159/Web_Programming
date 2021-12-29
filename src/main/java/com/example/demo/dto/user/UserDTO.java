package com.example.demo.dto.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;

    @JsonIgnore
    @JsonProperty(value = "password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("type")
    private String type;

    @JsonProperty("created_at")
    private Date createdAt;
    
    @JsonProperty("age")
    private Integer age;

    @JsonProperty("industry_code")
    private String industryCode;

    @JsonProperty("established_date")
    private Date establishedDate;

    @JsonProperty("total_capital")
    private Float totalCapital;
}
