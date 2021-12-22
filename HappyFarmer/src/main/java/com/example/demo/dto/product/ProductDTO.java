package com.example.demo.dto.product;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("sale")
    private String sale;

    @JsonProperty("category")
    private String category;

    @JsonProperty("expiration_date")
    private Date expiration_date;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private float price;

    @JsonProperty("disacount")
    private float disacount;

    @JsonProperty("quantity")
    private int quantity;
}
