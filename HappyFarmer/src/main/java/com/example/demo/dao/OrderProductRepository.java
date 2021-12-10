package com.example.demo.dao;

import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.OrderProductID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductID> {
}