package com.example.demo.controller.home;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.auth.AuthResponse;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.dto.auth.LoginDTO;
import com.example.demo.dto.auth.RegisterDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.service.user.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @Autowired 
    private CustomUserService customUserService;

  
    @PostMapping("/login")
    public BaseResponse login(@RequestBody UserDTO userDTO)
    {
        return customUserService.login(userDTO);
    }

    @PostMapping(value="/register")
    public BaseResponse register(@RequestBody UserDTO registerDto) 
    {
        
        return customUserService.registerUser(registerDto);
    }

    @GetMapping("/remove/{id}")
    public BaseResponse removeUser(@PathVariable("id") Integer userId)
    {
        System.out.println(userId);
        return customUserService.removeUser(userId);
    }
    
}
