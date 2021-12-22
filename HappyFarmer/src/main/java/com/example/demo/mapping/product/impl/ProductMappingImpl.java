package com.example.demo.mapping.product.impl;

import com.example.demo.dto.product.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.mapping.product.ProductMapping;

import org.springframework.stereotype.Component;

@Component
public class ProductMappingImpl implements ProductMapping{

    @Override
    public Product mapProductDtoToProduct(ProductDTO productDTO) {
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setExpirationDate(productDTO.getExpiration_date());
        product.setQuantity(productDTO.getQuantity());
        return product;
    }

    @Override
    public ProductDTO mapProductToProductDto(Product product) {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setExpiration_date(product.getExpirationDate());
        productDTO.setQuantity(product.getQuantity());
        return productDTO;
    }
    
}
