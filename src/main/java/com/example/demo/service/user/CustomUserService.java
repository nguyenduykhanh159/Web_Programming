package com.example.demo.service.user;

import java.util.ArrayList;


import com.example.demo.base.response.AuthenticationModel;
import com.example.demo.base.response.AuthenticationResponse;
import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.user.Farmer;
import com.example.demo.entity.user.Society;
import com.example.demo.entity.user.User;
import com.example.demo.entity.user.UserType;
import com.example.demo.mapping.user.UserMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapping<Farmer, UserDTO> farmerMapping;

    @Autowired
    private UserMapping<Society, UserDTO> societyMapping;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserDetails(user);
    }

    public BaseResponse registerUser(UserDTO userDTO)

    {
        try {
            String token = null;
            UserDTO user_respose=new UserDTO();
            user_respose.setAddress(userDTO.getAddress());
            user_respose.setName(userDTO.getName());
            user_respose.setEmail(userDTO.getEmail());
            user_respose.setUsername(userDTO.getUsername());

            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            String userType = userDTO.getType().toUpperCase();

            if (UserType.valueOf(userType) == UserType.FARMER) {
                Farmer farmer = farmerMapping.mapUserDtoToUser(userDTO);
                Cart cart = new Cart();
                cart.setUser(farmer);
                cart.setProducts(new ArrayList<>());

                cartRepository.save(cart);
                userRepository.save(farmer);
                token = jwtTokenProvider.generateToken(new CustomUserDetails(farmer));
            } else if (UserType.valueOf(userType) == UserType.SOCIETY) {
                Society society = societyMapping.mapUserDtoToUser(userDTO);
                Cart cart = new Cart();
                cart.setUser(society);
                cart.setProducts(new ArrayList<>());

                cartRepository.save(cart);
                society.setCart(cart);
                userRepository.save(society);
                token = jwtTokenProvider.generateToken(new CustomUserDetails(society));
            }
            AuthenticationModel authenticationModel = new AuthenticationModel();
            authenticationModel.setUser(user_respose);
            authenticationModel.setToken(token);

            return new AuthenticationResponse(HttpStatus.OK, "Register success",authenticationModel);
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.NOT_FOUND, "Register failed!" + e.getMessage());
        }

    }

    @Override
    public BaseResponse getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseResponse removeUser(int userId) {

        try {
            userRepository.deleteById(userId);
            return new BaseResponse<>(HttpStatus.OK, "Remove successful!");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Remove failed!" + e.getMessage());
        }

    }

    @Override
    public BaseResponse login(UserDTO userDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
            AuthenticationModel authenticationModel=new AuthenticationModel();
            authenticationModel.setUser(userDTO);
            authenticationModel.setToken(token);
            return new AuthenticationResponse(HttpStatus.OK, "login success",authenticationModel);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND, e.getMessage().toString());
        }
    }
}
