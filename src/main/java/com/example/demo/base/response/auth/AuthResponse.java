package com.example.demo.base.response.auth;



import java.util.Date;

import com.example.demo.base.response.BaseResponse;

import org.springframework.http.HttpStatus;




public class AuthResponse extends BaseResponse<AuthBody> {


    public AuthResponse(HttpStatus status, String message) {
        super(status, message);
    }
    public AuthResponse(HttpStatus status,String message,String username,String token)
    {
       super(status, message,new AuthBody(username,token,new Date()));

    }
}
