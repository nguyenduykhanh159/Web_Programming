package com.example.demo.entity.order;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity(name="order_product")
@Data
public class OrderProduct {

    @EmbeddedId
    private OrderProductID id;

    @Column(name="quantity")
    private int quanity;
    
    //1 order can have n product
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("order_id") 
    @JoinColumn(name="order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Order order;

    //1 product can be in n order
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("product_id")
    @JoinColumn(name="product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude   
    private Product product;

}
