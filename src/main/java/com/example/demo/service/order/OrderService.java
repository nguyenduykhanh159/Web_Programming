package com.example.demo.service.order;

import java.util.List;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.cart.CartDTO;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.dto.order.OrderDTO;

public interface OrderService {
    BaseResponse placeOrder(CartDTO cartDto);
    BaseResponse getOrderInfo();
}
