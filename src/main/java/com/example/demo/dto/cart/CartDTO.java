package com.example.demo.dto.cart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CartDTO {
  
    @JsonProperty("total_amount")
    private Float totalAmount;

    @JsonProperty("cart")
    private Collection<CartProductDTO> cart;
}
