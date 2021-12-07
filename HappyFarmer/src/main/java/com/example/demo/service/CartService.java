package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CartModel;

public interface CartService {
   
    public List<CartModel> getAllCarts();
    public void addCart(CartModel cart);
}
