package com.example.demo.mapping.cart.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.cart.CartDTO;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.cart.CartProduct;
import com.example.demo.entity.order.Order;
import com.example.demo.entity.order.OrderProduct;
import com.example.demo.entity.order.Product;
import com.example.demo.mapping.cart.CartMapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMappingImpl implements CartMapping {

    @Autowired
    private ModelMapper modelMapper;

    public Order mapCartToOrder(CartDTO cartDTO)
    {
        Collection<CartProductDTO> products= cartDTO.getCart();
        Order order =new Order();
        for(CartProductDTO cartProductDTO: products)
        {
            OrderProduct orderProduct=modelMapper.map(cartProductDTO, OrderProduct.class);
            order.getProducts().add(orderProduct);
        }
        return order;
    }

    public List<CartProductDTO> mapCartToCartDTO(Cart cart)
    {
        List<CartProductDTO> productInCarts=new ArrayList<>();
        Collection<CartProduct> products=cart.getProducts();
        for(CartProduct cartProduct: products)
        {
            Product product=cartProduct.getProduct();
            CartProductDTO cartProductDTO=new CartProductDTO();
            cartProductDTO.setId(product.getId());
            cartProductDTO.setBoughtQuantity(cartProduct.getBoughtQuantity());
            cartProductDTO.setPrice(product.getPrice());
            cartProductDTO.setName(product.getName());
            cartProductDTO.setImageUrl(product.getImageUrl());
            cartProductDTO.setQuantity(product.getQuantity());
            productInCarts.add(cartProductDTO);
        }
        return productInCarts;
    }

}
