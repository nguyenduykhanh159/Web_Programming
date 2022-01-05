package com.example.demo.entity.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.cart.CartProduct;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<OrderProduct> orders;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<CartProduct> carts;
}
