package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity(name="ordez")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderProduct> products=new HashSet<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    public Set<OrderProduct> getProducts() {
        return products;
    }
}
