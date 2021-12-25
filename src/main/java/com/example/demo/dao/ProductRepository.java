package com.example.demo.dao;

import com.example.demo.entity.order.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}