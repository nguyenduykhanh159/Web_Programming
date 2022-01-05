package com.example.demo.service.user;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.base.response.AuthenticationModel;
import com.example.demo.base.response.AuthenticationResponse;
import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.user.Profile;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.job.Job;
import com.example.demo.entity.order.Order;
import com.example.demo.entity.order.OrderProduct;
import com.example.demo.entity.user.Farmer;
import com.example.demo.entity.user.FarmerJob;
import com.example.demo.entity.user.Society;
import com.example.demo.entity.user.User;
import com.example.demo.entity.user.UserType;
import com.example.demo.mapping.user.UserMapping;
import com.fasterxml.jackson.databind.JsonSerializable.Base;

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

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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

            UserDTO user_respose = new UserDTO();
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

            } else if (UserType.valueOf(userType) == UserType.SOCIETY) {
                Society society = societyMapping.mapUserDtoToUser(userDTO);
                Cart cart = new Cart();
                cart.setUser(society);
                cart.setProducts(new ArrayList<>());

                cartRepository.save(cart);
                society.setCart(cart);
                userRepository.save(society);

            }
            AuthenticationModel authenticationModel = new AuthenticationModel();
            authenticationModel.setUser(user_respose);

            return new AuthenticationResponse(HttpStatus.OK, "Register success", authenticationModel);
        } catch (Exception e) {

            log.error(e.getMessage(), e.getCause());
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

            log.error(e.getMessage(), e.getCause());

            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Remove failed!" + e.getMessage());
        }

    }

    @Override
    public BaseResponse login(UserDTO userDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String token = jwtTokenProvider.generateToken((userDetails));
            AuthenticationModel authenticationModel = new AuthenticationModel();

            User user = userDetails.getUser();
            UserDTO user_response = new UserDTO();
            user_response.setAddress(user.getAddress());
            user_response.setName(user.getName());
            user_response.setEmail(user.getEmail());
            user_response.setUsername(user.getUsername());
            user_response.setPhone(user.getPhone());
            user_response.setCreatedAt(user.getCreatedAt());
            user_response.setImageUrl(user.getImageUrl());

            authenticationModel.setUser(user_response);
            authenticationModel.setToken(token);

            return new AuthenticationResponse(HttpStatus.OK, "login success", authenticationModel);
        } catch (Exception e) {

            log.error(e.getMessage(), e.getCause());

            return new BaseResponse<>(HttpStatus.NOT_FOUND, e.getMessage().toString());
        }
    }

    @Override
    public BaseResponse updateProfile(UserDTO userDTO) {
        try {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            User user = userRepository.findById(userDetails.getUser().getId()).get();
            user.setImageUrl(userDTO.getImageUrl());
            userRepository.save(user);
            return new BaseResponse<>(HttpStatus.OK, "Update profile successfull!");

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Update failed!");
        }

    }

    @Override
    public BaseResponse profile() {
        try {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            User user = userRepository.findById(userDetails.getUser().getId()).get();

            Integer createdJob=user.getCreatedJobs().size();
            Integer receivedJob=user.getDoJobs().size();

            Integer numOrders=user.getOrders().size();
            Integer numProducts=0;
            Collection<Order> orders=user.getOrders();
            for(Order order:orders)
            {
                Collection<OrderProduct> orderProducts = order.getProducts();
                for(OrderProduct orderProduct:orderProducts)
                {
                    numProducts+=orderProduct.getQuanity();
                }
            }
            

            UserDTO user_response = new UserDTO();
            user_response.setAddress(user.getAddress());
            user_response.setName(user.getName());
            user_response.setEmail(user.getEmail());
            user_response.setUsername(user.getUsername());
            user_response.setPhone(user.getPhone());
            user_response.setCreatedAt(user.getCreatedAt());
            user_response.setImageUrl(user.getImageUrl());
            user_response.setDateOfBirth(user.getDateOfBirth());
            
            Profile profile=new Profile();
            profile.setUser(user_response);
            profile.setCreatedJob(createdJob);
            profile.setReceivedJob(receivedJob);
            profile.setNumberOfOrders(numOrders);
            profile.setNumOfProducts(numProducts);
            
             return new BaseResponse<>(HttpStatus.OK, "Your profile!",profile);

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Get failed!");
        }
       
    }
}
