package com.example.demo.entity;


import javax.persistence.*;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity(name="usez")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @Column(name="name")
    private String name;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Order> orders=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> authorities=new HashSet<>();
}
