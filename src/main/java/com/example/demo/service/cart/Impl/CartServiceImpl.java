package com.example.demo.service.cart.Impl;


import java.util.Collection;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dao.CartProductRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.cart.CartProduct;
import com.example.demo.entity.cart.CartProductID;
import com.example.demo.entity.order.Product;
import com.example.demo.entity.user.User;
import com.example.demo.mapping.cart.Impl.CartMappingImpl;
import com.example.demo.service.cart.CartService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private CartMappingImpl cartMapping;

    @PersistenceContext
    private EntityManager entityManager;

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

            CartProductID cartProductID = new CartProductID(cart.getId(), cartProductDTO.getId());

            CartProduct cartProduct = cartProductRepository.findById(cartProductID).orElse(null);
            if (cartProduct != null) {
                int boughtQuantity = cartProduct.getBoughtQuantity();
                if (cartProductDTO.getBoughtQuantity() != null) {
                    cartProduct.setBoughtQuantity(boughtQuantity + cartProductDTO.getBoughtQuantity());
                } else {
                    cartProduct.setBoughtQuantity(boughtQuantity + 1);
                }

            } else {
                cartProduct = new CartProduct();
                cartProduct.setCartProductID(cartProductID);
                cartProduct.setBoughtQuantity(1);
                cartProduct.setCart(cart);
                cartProduct.setProduct(product);

            }

            cartProductRepository.save(cartProduct);

            return new BaseResponse<>(HttpStatus.OK, "Add successfully!");
        } catch (Exception ex) {

            log.error(ex.getMessage(), ex.getCause());
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
            log.error(e.getMessage(), e.getCause());
            return null;
        }

    }

    @Override
    public BaseResponse removeProductFromCart(CartProductDTO cartProductDTO) {

        try {
            Cart cart = getCart();
            CartProductID cartProductID = new CartProductID(cart.getId(), cartProductDTO.getId());

            cartProductRepository.deleteById(cartProductID);

            return new BaseResponse<>(HttpStatus.OK, "Remove success");

        } catch (Exception ex) {

            log.error(ex.getMessage(), ex.getCause());

            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Remove failed!");
        }
    }

    @Override
    @Transactional
    public BaseResponse removeAllProductsFromCart() {
        try {

            Cart cart = getCart();

           
            Collection<CartProduct> cartProducts = cart.getProducts();

            for (CartProduct cartProduct : cartProducts) {
               
                entityManager.remove(cartProduct);
            }
           

          
            return new BaseResponse<>(HttpStatus.OK, "Remove all product");

        } catch (

        Exception e) {
            log.error(e.getMessage(), e.getCause());
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Remove failed");
        }

    }
}
