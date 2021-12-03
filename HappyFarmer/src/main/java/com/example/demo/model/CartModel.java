package com.example.demo.model;

import java.util.List;

public class CartModel {
    private int cartId;
    private List<ProductDetail> products;

    public int getCartId() {
        return this.cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<ProductDetail> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductDetail> products) {
        this.products = products;
    }
    
    
}
