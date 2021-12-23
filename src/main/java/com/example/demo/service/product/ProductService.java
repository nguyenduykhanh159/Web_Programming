package com.example.demo.service.product;

import java.util.List;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.product.ProductDTO;

public interface ProductService {
    BaseResponse<ProductDTO> getAllProducts();
    BaseResponse<ProductDTO> getProduct(int productId);
    BaseResponse addProduct(ProductDTO productDTO);
    BaseResponse removeProduct(int productId);

}
