package com.example.demo.base.response;

import java.util.List;

import com.example.demo.dto.product.ProductDTO;

import org.springframework.http.HttpStatus;

public class ProductResponse extends BaseResponse<ProductDTO> {

    public ProductResponse(HttpStatus status, String message) {
        super(status, message);
        //TODO Auto-generated constructor stub
    }
    public ProductResponse(HttpStatus status,String message, List<ProductDTO> products)
    {
        super(status, message,products);
    }
     public ProductResponse(HttpStatus status,String message, ProductDTO products)
    {
        super(status, message,products);
    }
}
