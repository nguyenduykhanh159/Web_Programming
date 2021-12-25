package com.example.demo.mapping.product.impl;

import com.example.demo.dto.product.ProductDTO;
import com.example.demo.entity.order.Product;
import com.example.demo.mapping.product.ProductMapping;

import org.springframework.stereotype.Component;

@Component
public class ProductMappingImpl implements ProductMapping{

    @Override
    public Product mapProductDtoToProduct(ProductDTO productDTO) {
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setExpirationDate(productDTO.getExpirationDate());
        product.setCategory(productDTO.getCategory());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        product.setDiscount(productDTO.getDiscount());
        product.setImageUrl(productDTO.getImageUrl());
        product.setSale(productDTO.getSale());
        return product;
    }

    @Override
    public ProductDTO mapProductToProductDto(Product product) {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setExpirationDate(product.getExpirationDate());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setCategory(product.getCategory());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setId(product.getId());
        productDTO.setSale(product.getSale());
        return productDTO;
    }
    
}
