package com.example.demo.service;

import java.util.List;

import com.example.demo.model.OrderModel;

public interface OrderService {
   public OrderModel getOrderInfo(int orderId);
    public List<OrderModel> getAllOrders();
    public void addOrder(OrderModel order); 
}
