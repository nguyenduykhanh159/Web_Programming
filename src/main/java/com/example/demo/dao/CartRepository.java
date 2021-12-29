package com.example.demo.dao;

import com.example.demo.entity.cart.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    
}
