package com.example.demo.config.jwt;

import java.util.Calendar;
import java.util.Date;

import com.example.demo.entity.CustomUserDetails;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
    private static String secret = "quanify";

    public String generateToken(CustomUserDetails userDetails) {
        try {
            Date now = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.add(Calendar.DATE, 1);
            Date expiredDate = c.getTime();
            return Jwts.builder().setSubject(userDetails
                    .getUsername())
                    .setIssuedAt(now)
                    .setExpiration(expiredDate)
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        } catch (Exception e) {
           
            return e.getMessage();
        }
       

    }

    public boolean validateToken(String token) {

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (ExpiredJwtException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (UnsupportedJwtException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }

    public String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return e.getStackTrace().toString();
        }

    }
}
