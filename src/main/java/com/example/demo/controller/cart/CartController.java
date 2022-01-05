package com.example.demo.controller.cart;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.service.cart.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;

    @GetMapping
    public BaseResponse getCartInfo()
    {
        return cartService.getCartInfo();
    }
    
    @PostMapping
    public BaseResponse addProductToCart(@RequestBody CartProductDTO cartProductDTO)
    {
        return cartService.addProductToCart(cartProductDTO);
    }

    @DeleteMapping
    public BaseResponse removeProductFromCart(@RequestBody CartProductDTO cartProductDTO)
    {
        return cartService.removeProductFromCart(cartProductDTO);
    }

    @GetMapping("/removeAll")
    public BaseResponse removeAllProductsFromCart()
    {
        return cartService.removeAllProductsFromCart();
    }
}
