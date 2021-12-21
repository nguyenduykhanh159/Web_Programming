package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "workplace")
@Data
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    @Column(name="type_work")
   private String typeWork;
   @Column(name="area")
   private float area;
   @Column(name="address")
   private String address;


   // n workplace can be owned by 1 farmer
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @OneToMany(mappedBy = "workplace")
    private Set<Job> jobs=new HashSet<>();
 
}
