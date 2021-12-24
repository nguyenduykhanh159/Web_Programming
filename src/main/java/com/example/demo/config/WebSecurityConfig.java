package com.example.demo.config;

import com.example.demo.config.jwt.JwtTokenFilter;
import com.example.demo.service.user.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService userService;

    @Autowired 
    private JwtTokenFilter jwtTokenFilter;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManager();
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     // TODO Auto-generated method stub
    //     auth.userDetailsService(userService).passwordEncoder(getPasswordEncoder());
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub


      http 
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login","/register").permitAll()
        .anyRequest().authenticated().and();
    http.addFilterBefore(jwtTokenFilter,UsernamePasswordAuthenticationFilter.class);
    
    }
}
