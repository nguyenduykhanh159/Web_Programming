package com.example.demo.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.service.user.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String header=request.getHeader("Authorization");
            if(header.isEmpty() || !header.startsWith("Bearer"))
            {
                filterChain.doFilter(request, response);
                return;
            }

            String token=header.substring(7);
            if(!jwtTokenProvider.validateToken(token))
            {
                filterChain.doFilter(request, response);
                return;
            }
            UserDetails userDetails=userService.loadUserByUsername(jwtTokenProvider.getUsernameFromToken(token));
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            //TODO: handle exceptioncredentials
            System.out.println(e.getMessage());
             filterChain.doFilter(request, response);
             return;
        }
      
        
    }
    
}
