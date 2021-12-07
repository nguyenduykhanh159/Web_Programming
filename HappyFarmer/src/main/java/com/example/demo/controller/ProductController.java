package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductModel getProduct(int prodId) {
        return productService.getProduct(prodId);
    }

    @PostMapping
    public int addProduct(@RequestBody ProductModel prod) {
        productService.addProduct(prod);
        return 1;
    }
}
