package com.example.demo.dto.cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartProductDTO {
   
    @JsonProperty("product_id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private Integer quantity;
    
    @JsonProperty("bought_quantity")
    private Integer boughtQuantity;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("category")
    private String category;

    @JsonProperty("discount")
    private Float discount;

    @JsonProperty("sale")
    private Float sale;
    


    
}
