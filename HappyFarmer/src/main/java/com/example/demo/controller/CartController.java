package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.model.CartModel;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private CartService cartService;
    @Autowired
    public CartController(CartService cartService)
    {
        this.cartService=cartService;
    }
    @GetMapping("")
    public List<CartModel> getAllCarts()
    {
        return cartService.getAllCarts();
    }
    @GetMapping("/{cartid}")
   public CartModel getCartInfo(@PathVariable("cartid") Integer cartid)
   {
       return cartService.getCartInfo(cartid);
   } 
}
