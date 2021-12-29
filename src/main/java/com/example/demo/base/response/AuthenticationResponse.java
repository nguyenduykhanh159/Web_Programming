package com.example.demo.base.response;

import org.springframework.http.HttpStatus;

public class AuthenticationResponse extends BaseResponse<AuthenticationModel> {

    public AuthenticationResponse(HttpStatus status, String message) {
        super(status, message);
    }
    public AuthenticationResponse(HttpStatus status,String message,AuthenticationModel authenticationModel)
    {
        super(status, message,authenticationModel);
    }
    
}
