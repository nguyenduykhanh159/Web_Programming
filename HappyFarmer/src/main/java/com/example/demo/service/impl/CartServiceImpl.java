package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.model.CartModel;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartServiceImpl implements CartService{
    private MockDataRepo cartRepo;
    @Autowired
    public CartServiceImpl(MockDataRepo repo)
    {
        this.cartRepo=repo;
    }

    @Override
    public List<CartModel> getAllCarts() {
        // TODO Auto-generated method stub
        return cartRepo.getAllCarts();
    }
    @Override
    public void addCart(CartModel cart) {
        // TODO Auto-generated method stub
        cartRepo.addCart(cart);
        
    }
    
}
