package com.example.demo.entity.user;

import javax.persistence.*;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.job.Job;
import com.example.demo.entity.notification.Notification;
import com.example.demo.entity.order.Order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity(name = "usez")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name="image_url",columnDefinition = "TEXT")
    private String imageUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Order> orders;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> authorities = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Job> createdJobs;

    @OneToMany(mappedBy = "worker")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<FarmerJob> doJobs;

    @OneToMany(mappedBy = "owner")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Notification> notifications;

}
