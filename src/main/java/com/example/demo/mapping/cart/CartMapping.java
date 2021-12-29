package com.example.demo.mapping.cart;

import java.util.List;

import com.example.demo.dto.cart.CartDTO;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.order.Order;

public interface CartMapping {
    Order mapCartToOrder(CartDTO cartDTO);
    List<CartProductDTO> mapCartToCartDTO(Cart cart);
}
