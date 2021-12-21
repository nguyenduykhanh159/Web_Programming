package com.example.demo.mapping;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;

public interface ProductMapping {
    Product mapProductDtoToProduct(ProductDTO productDTO);
}
