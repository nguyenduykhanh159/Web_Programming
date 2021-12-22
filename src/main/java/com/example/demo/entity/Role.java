package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity(name="role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String authority;

    @ManyToMany(mappedBy = "authorities",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<User> users=new HashSet<>();

}
