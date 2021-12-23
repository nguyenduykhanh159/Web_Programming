package com.example.demo.controller.product;


import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.product.ProductDTO;
import com.example.demo.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public BaseResponse getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public BaseResponse getProduct(@PathVariable("id") Integer productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public BaseResponse addProduct(@RequestBody ProductDTO productDTO) {
        
        return productService.addProduct(productDTO);
    }
    @DeleteMapping("/{id}")
    public BaseResponse removeProduct(@PathVariable("id") Integer productId)
    {
        return productService.removeProduct(productId);
    }
}
