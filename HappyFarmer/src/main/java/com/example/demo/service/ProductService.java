package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDTO;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProduct(int prodId);
    public void addProduct(ProductDTO prod);
}
