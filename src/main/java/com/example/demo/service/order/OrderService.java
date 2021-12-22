package com.example.demo.service.order;

import java.util.List;

import com.example.demo.dto.OrderDTO;

public interface OrderService {
   public OrderDTO getOrderInfo(int orderId);
    public List<OrderDTO> getAllOrders();
    public void addOrder(OrderDTO order); 
}
