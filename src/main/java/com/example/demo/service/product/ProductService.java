package com.example.demo.service.product;

import java.util.List;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.product.ProductDTO;

public interface ProductService {
    BaseResponse getAllProducts();
    BaseResponse getProduct(int productId);
    BaseResponse addProduct(ProductDTO productDTO);
    BaseResponse removeProduct(int productId);

}
