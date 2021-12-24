package com.example.demo.controller.home;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.auth.AuthResponse;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.dto.auth.LoginDTO;
import com.example.demo.dto.auth.RegisterDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.service.user.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private JwtTokenProvider jwtTokenProvider;

    @Autowired CustomUserService customUserService;

    @GetMapping("/login_success")
    public String login_success()
    {
        return "ok";
    }

    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginDTO loginDTO,HttpServletResponse response)
    {
        System.out.println(loginDTO);
        try
        {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtTokenProvider.generateToken((CustomUserDetails)authentication.getPrincipal());
        Cookie cookie=new Cookie("token", token);
        cookie.setMaxAge(30);
        Cookie cookie2=new Cookie("username", loginDTO.getUsername());
        cookie2.setMaxAge(30);
        response.addCookie(cookie);
        response.addCookie(cookie2);
        return new AuthResponse(HttpStatus.OK, "login success",loginDTO.getUsername(),token);
        }catch (Exception e)
        {
            return new BaseResponse<>(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(value="/register")
    public BaseResponse postMethodName(@RequestBody RegisterDTO registerDto) 
    {
        
        return customUserService.registerUser(registerDto);
    }
    
}
