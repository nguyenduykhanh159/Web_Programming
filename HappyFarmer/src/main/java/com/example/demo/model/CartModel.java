package com.example.demo.model;

import java.util.List;

public class CartModel {
    private List<ProductDetail> products;

   
    public List<ProductDetail> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductDetail> products) {
        this.products = products;
    }
   public String getCartInfo(CartModel cart)
   {
       return cart.getProducts().size()+" products";
   } 
    
}
