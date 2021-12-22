package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("")
    public List<OrderDTO> getAllOrders()
    {
        return orderService.getAllOrders();
    }
    @GetMapping("/{orderid}")
   public OrderDTO getOrderInfo(@PathVariable("orderid") Integer orderid)
   {
       return orderService.getOrderInfo(orderid);
   }
   @PostMapping("")
   public OrderDTO addOrder(@RequestBody OrderDTO order)
   {
       orderService.addOrder(order);
       return order;
   }  
}
