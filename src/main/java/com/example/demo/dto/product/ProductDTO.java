package com.example.demo.dto.product;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("sale")
    private int sale;

    @JsonProperty("category")
    private String category;

    @JsonProperty("expiration_date")
    private Date expirationDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private float price;

    @JsonProperty("discount")
    private float discount;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("description")
    private String description;
}
