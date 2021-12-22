package com.example.demo.service.product;

import java.util.List;

import com.example.demo.dto.product.ProductDTO;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProduct(int productId);
    boolean addProduct(ProductDTO productDTO);
    boolean removeProduct(int productId);


    
}
