package com.example.demo.service.cart.Impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.order.Product;
import com.example.demo.entity.user.User;
import com.example.demo.mapping.cart.Impl.CartMappingImpl;
import com.example.demo.service.cart.CartService;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartMappingImpl cartMapping;

    @Override
    public BaseResponse getCartInfo() {
        try {
            Cart cart = getCart();
            return new BaseResponse<>(HttpStatus.OK, "Cart info", cartMapping.mapCartToCartDTO(cart));
        } catch (Exception ex) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Get error!", ex.getMessage());
        }
    }

    @Override
    public BaseResponse addProductToCart(CartProductDTO cartProductDTO) {
        try {
            Cart cart = getCart();
            Product product = productRepository.getById(cartProductDTO.getId());
            cart.getProducts().add(product);
            cartRepository.save(cart);

            return new BaseResponse<>(HttpStatus.OK, "Add successfully!", cartMapping.mapCartToCartDTO(cart));
        } catch (Exception ex) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Add failed!" + ex.getMessage());
        }
    }

    private Cart getCart() {
        try {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();

            User user = userRepository.getById(userDetails.getUser().getId());

            Cart cart = user.getCart();
            return cart;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }

    }

    @Override
    public BaseResponse removeProductFromCart(CartProductDTO cartProductDTO) {

        try {
            Cart cart = getCart();
            Collection<Product> products = cart.getProducts();
            for (Product product : products) {
                if (product.getId() == cartProductDTO.getId()) {
                    cart.getProducts().remove(product);
                    break;
                }
            }
            cartRepository.save(cart);

            return new BaseResponse<>(HttpStatus.OK, "Remove success", cartMapping.mapCartToCartDTO(cart));

        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Remove failed!");
        }
    }
}
