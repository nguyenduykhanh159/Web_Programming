package com.example.demo.service.product.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.ProductResponse;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.product.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.mapping.product.ProductMapping;
import com.example.demo.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired 
    private ProductRepository productRepository;

    @Autowired
    private ProductMapping productMapping;

    @Override
    public BaseResponse getAllProducts() {
        List<Product> products=productRepository.findAll();
        return new BaseResponse<>(HttpStatus.OK, "All products",products.stream().map(product->productMapping.mapProductToProductDto(product)).collect(Collectors.toList()));
    }

    @Override
    public BaseResponse getProduct(int productId) {
        Product product=productRepository.getById(productId);
        return new BaseResponse<>(HttpStatus.OK,"Product",productMapping.mapProductToProductDto(product));
    }

    @Override
    public BaseResponse addProduct(ProductDTO productDTO) {
        try {
            Product product=productMapping.mapProductDtoToProduct(productDTO);
            productRepository.save(product);
            return new BaseResponse<>(HttpStatus.OK,"Add success!",productDTO);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Error!");
    }

    @Override
    public BaseResponse removeProduct(int productId) {
       try {
           productRepository.deleteById(productId);
           return new BaseResponse<>(HttpStatus.OK,"Remove success!");
       } catch (Exception e) {
            e.getStackTrace();
       }
        return new BaseResponse<>(HttpStatus.BAD_REQUEST,"Remove failed!");
    }
    
}
