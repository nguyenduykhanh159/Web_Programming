package com.example.demo.service.user;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.auth.AuthResponse;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.auth.RegisterDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.user.User;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private UserMapping<User,RegisterDTO> userMapping;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        User user=userRepository.findByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserDetails(user);
    }
   
    public BaseResponse registerUser(RegisterDTO registerDTO)
    
    {
        try
        {
            User user= userMapping.mapUserDtoToUser(registerDTO);
            userRepository.save(user);
            String token=jwtTokenProvider.generateToken(new CustomUserDetails(user));
            return new AuthResponse(HttpStatus.OK,"Register success",user.getUsername(),token);
        }catch (Exception e)
        {
             return new NotFoundResponse(HttpStatus.NOT_FOUND,"Register failed!"+e.getMessage());
        }
       
        
    }
}
