package com.example.demo.entity.cart;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.demo.entity.order.Product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "cart_product")
@Data
public class CartProduct {

    @EmbeddedId
    private CartProductID cartProductID;

    @Column(name = "bought_quantity")
    private Integer boughtQuantity;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cart cart;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH},fetch = FetchType.LAZY)
    @MapsId("product_id")
    @JoinColumn(name="product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;

}
