package com.example.demo.entity.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.entity.cart.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name="name")
   private String name;

   @Column(name = "image_url")
   private String imageUrl;

   @Column(name="sale")
   private int sale;
   
   @Column(name = "category")
   private String category;
   
   @Column(name="expiration_date")
   @Temporal(TemporalType.DATE)
   private Date expirationDate;

   @Column(name="price")
   private float price;

   @Column(name = "discount")
   private float discount;

   @Column(name="quantity")
   private int quantity;

   @Column(name="description")
   private String description;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderProduct> orders=new HashSet<>();

    // @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    // @JsonIgnore
    // private Set<Cart> carts;
}
