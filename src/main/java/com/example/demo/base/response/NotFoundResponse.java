package com.example.demo.base.response;

import org.springframework.http.HttpStatus;

public class NotFoundResponse extends BaseResponse<String> {

    public NotFoundResponse(HttpStatus status, String message) {
        super(status, message);  
    }
    
}
