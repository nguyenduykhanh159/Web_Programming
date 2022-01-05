package com.example.demo.dao;

import com.example.demo.entity.cart.CartProduct;
import com.example.demo.entity.cart.CartProductID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct,CartProductID> {

 
}
