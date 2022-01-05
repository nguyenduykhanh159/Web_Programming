package com.example.demo.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProductDTO {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("price")
    private Float price;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("iamge_url")
    private String imageUrl;
}
