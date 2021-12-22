package com.example.demo.dto.product;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductDTO {
    @JsonProperty("expiration_date")
    private Date expirationDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private float price;

    @JsonProperty("quantity")
    private int quantity;
}
