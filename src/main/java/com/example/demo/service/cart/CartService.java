package com.example.demo.service.cart;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.cart.CartProductDTO;

public interface CartService {
    BaseResponse getCartInfo();
    BaseResponse addProductToCart(CartProductDTO cartProductDTO);
    BaseResponse removeProductFromCart(CartProductDTO cartProductDTO);
    BaseResponse removeAllProductsFromCart();
}
