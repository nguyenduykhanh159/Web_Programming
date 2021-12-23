package com.example.demo.base.response;

import org.springframework.http.HttpStatus;

public class NotFoundResponse extends BaseResponse {

    public NotFoundResponse(HttpStatus status, String message) {
        super(status, message);  
    }
    
}
