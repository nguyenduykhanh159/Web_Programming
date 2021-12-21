package com.example.demo.mapping.impl;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.mapping.ProductMapping;

import org.springframework.stereotype.Component;

@Component
public class ProductMappingImpl implements ProductMapping {
    @Override
    public Product mapProductDtoToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setExpirationDate(productDTO.getExpiration_date());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return product;
    }
}
