package com.example.demo.mapping.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;
import com.example.demo.mapping.OrderMapping;

import org.springframework.stereotype.Component;

@Component
public class OrderMappingImpl implements OrderMapping {
    @Override
    public Order mapOrderDtoToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCreatedAt(orderDTO.getCreate_at());
        return order;
    }
}
