package com.example.demo.controller.product;

import java.util.List;

import com.example.demo.dto.product.ProductDTO;
import com.example.demo.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Integer productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public boolean addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return true;
    }
}
