package com.example.demo.service.product.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.product.ProductDTO;
import com.example.demo.entity.order.Product;
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
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = products.stream().map(product -> productMapping.mapProductToProductDto(product))
                .collect(Collectors.toList());
        return new BaseResponse<>(HttpStatus.OK, "All products", productsDTO);
    }

    @Override
    public BaseResponse getProduct(int productId) {
        try {
            Product product = productRepository.getById(productId);
            ProductDTO productDTO = productMapping.mapProductToProductDto(product);
            return new BaseResponse<>(HttpStatus.OK, "Product", productDTO);
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.NOT_FOUND, "Not found! " + e.getMessage());
        }

    }

    @Override
    public BaseResponse addProduct(ProductDTO productDTO) {
        try {
            Product product = productMapping.mapProductDtoToProduct(productDTO);
            productRepository.save(product);
            productDTO=productMapping.mapProductToProductDto(product);
            return new BaseResponse<>(HttpStatus.OK, "Add successfully!", productDTO);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Add failed! " + e.getMessage());
        }

    }

    @Override
    public BaseResponse removeProduct(int productId) {
        try {
            productRepository.deleteById(productId);
            return new BaseResponse<>(HttpStatus.OK, "Remove successful!");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Remove failed! " + e.getMessage());
        }

    }

}
