package com.example.demo.dao;

import com.example.demo.entity.order.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}