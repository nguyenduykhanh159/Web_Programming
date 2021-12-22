// package com.example.demo.controller;

// import java.util.List;

// import com.example.demo.model.CartModel;
// import com.example.demo.service.CartService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/v1/cart")
// public class CartController {
//     private CartService cartService;
//     @Autowired
//     public CartController(CartService cartService)
//     {
//         this.cartService=cartService;
//     }
//     @GetMapping("")
//     public List<CartModel> getAllCarts()
//     {
//         return cartService.getAllCarts();
//     }
//    @PostMapping("")
//    public CartModel addCart(@RequestBody CartModel cart)
//    {
//        cartService.addCart(cart);
//        return cart;
//    } 
// }
