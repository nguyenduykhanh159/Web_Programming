package com.example.demo.mapping;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;

public interface OrderMapping {
    Order mapOrderDtoToOrder(OrderDTO orderDTO);
}
