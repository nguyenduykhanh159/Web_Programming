package com.example.demo.dto.cart;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class CartDTO {
   
    private Set<CartProductDTO> carts=new HashSet<>();
}
