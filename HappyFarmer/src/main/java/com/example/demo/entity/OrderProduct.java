package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductID id;

    @Column(name="quantity")
    private int quanity;
    
    //1 order can have n product
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("order_id")
    @JsonIgnore
    @JoinColumn(name="order_id")
    private Order order;

    //1 product can be in n order
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("product_id")
    @JsonIgnore
    @JoinColumn(name="product_id")
    private Product product;





    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuanity() {
        return this.quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

   
}
