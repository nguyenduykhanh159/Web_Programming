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
        product.setId(productDTO.getId());
        product.setImage_url(productDTO.getImage_url());
        product.setCategory(productDTO.getCategory());
        product.setDiscount(productDTO.getDiscount());
        product.setSale(productDTO.getSale());
        return product;
    }

    @Override
    public ProductDTO mapProductToProductDto(Product product) {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setExpiration_date(product.getExpirationDate());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setId(product.getId());
        productDTO.setImage_url(product.getImage_url());
        productDTO.setCategory(product.getCategory());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setSale(product.getSale());
        return productDTO;
    }
    
}
