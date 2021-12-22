package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
   private String image_url;

   @Column(name = "sale")
   private String sale;

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

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderProduct> orders=new HashSet<>();
}
