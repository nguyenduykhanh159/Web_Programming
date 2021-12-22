package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="farmer")
@Data
public class Farmer extends User {
    @Column(name="age")
    private int age;


    //1 farmer can have n workplaces
    @OneToMany(mappedBy = "farmer")
    private Set<Workplace> workplaces=new HashSet<Workplace>();
    //1 farmer create n jobs
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<Job> createdJob =new HashSet<Job>();
    

    //1 farmer do n jobs
    @OneToMany(mappedBy = "worker")
    @JsonIgnore
    private Set<FarmerJob> doJob=new HashSet<FarmerJob>();

    @OneToMany(mappedBy = "farmer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<FarmerSociety> societies=new HashSet<>();
   
}
