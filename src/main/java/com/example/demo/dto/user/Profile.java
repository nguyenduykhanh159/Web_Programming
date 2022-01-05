package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {

    @JsonProperty("user")
    private UserDTO user;

    @JsonProperty("created_job")
    private Integer createdJob;

    @JsonProperty("received_job")
    private Integer receivedJob;

    @JsonProperty("num_orders")
    private Integer numberOfOrders;

    @JsonProperty("num_products")
    private Integer numOfProducts;
    
}
