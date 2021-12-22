package com.example.demo.mapping.product;

import com.example.demo.dto.product.ProductDTO;
import com.example.demo.entity.Product;

public interface ProductMapping {
   Product mapProductDtoToProduct(ProductDTO productDTO);
   ProductDTO mapProductToProductDto(Product product); 
}
