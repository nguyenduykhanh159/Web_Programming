package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductModel;

public interface ProductService {
    public List<ProductModel> getAllProducts();
    public ProductModel getProduct(int prodId);
    public void addProduct(ProductModel prod);
}
