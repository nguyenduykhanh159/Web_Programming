package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.model.OrderModel;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired 
    private MockDataRepo repo;

    @Override
    public OrderModel getOrderInfo(int orderId) {
        // TODO Auto-generated method stub
        return repo.getOrderInfo(orderId);
    }

    @Override
    public List<OrderModel> getAllOrders() {
        // TODO Auto-generated method stub

        return repo.getAllOrders();
    }

    @Override
    public void addOrder(OrderModel order) {
        // TODO Auto-generated method stub
        repo.addOrder(order);
        
    }
    
}
