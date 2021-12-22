package com.example.demo.service.product.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.product.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.mapping.product.ProductMapping;
import com.example.demo.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired 
    private ProductRepository productRepository;

    @Autowired
    private ProductMapping productMapping;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product->productMapping.mapProductToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(int productId) {
        Product product=productRepository.getById(productId);
        return productMapping.mapProductToProductDto(product);
    }

    @Override
    public boolean addProduct(ProductDTO productDTO) {
        try {
            Product product=productMapping.mapProductDtoToProduct(productDTO);
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeProduct(int productId) {
       try {
           productRepository.deleteById(productId);
           return true;
       } catch (Exception e) {
            e.getStackTrace();
       }
        return false;
    }
    
}
