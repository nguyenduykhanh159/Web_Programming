package com.example.demo.entity.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.example.demo.entity.order.Product;
import com.example.demo.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name="cart")
@Data
public class Cart implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "cart_product",joinColumns = @JoinColumn(name="cart_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Product> products;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",unique = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;
}
