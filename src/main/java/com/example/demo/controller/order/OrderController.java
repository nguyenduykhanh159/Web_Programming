package com.example.demo.controller.order;

import java.util.List;
import java.util.Set;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dto.cart.CartDTO;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.dto.order.OrderDTO;
import com.example.demo.dto.order.OrderProductDTO;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.order.Order;
import com.example.demo.entity.order.OrderProduct;
import com.example.demo.service.order.OrderService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public BaseResponse placeOrder(@RequestBody CartDTO cartDto) {

        return orderService.placeOrder(cartDto);
    }

    @GetMapping
    public BaseResponse getOrderInfo() {
        return orderService.getOrderInfo();

    }
}
