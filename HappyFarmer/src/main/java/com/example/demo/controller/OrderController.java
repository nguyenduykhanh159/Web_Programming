package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.CartModel;
import com.example.demo.model.OrderModel;
import com.example.demo.service.OrderService;

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
    public List<OrderModel> getAllOrders()
    {
        return orderService.getAllOrders();
    }
    @GetMapping("/{orderid}")
   public OrderModel getOrderInfo(@PathVariable("orderid") Integer orderid)
   {
       return orderService.getOrderInfo(orderid);
   }
   @PostMapping("")
   public OrderModel addOrder(@RequestBody OrderModel order)
   {
       orderService.addOrder(order);
       return order;
   }  
}
