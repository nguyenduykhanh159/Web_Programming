package com.example.demo.entity.cart;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductID implements Serializable {
    private static final long serialVersionUID=-8531790606923276999L;

    @Column(name="cart_id")
    private int cartId;

    @Column(name="product_id")
    private int productId;
}
