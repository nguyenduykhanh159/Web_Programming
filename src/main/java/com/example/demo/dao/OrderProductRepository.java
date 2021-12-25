package com.example.demo.dao;

import com.example.demo.entity.order.OrderProduct;
import com.example.demo.entity.order.OrderProductID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductID> {
}