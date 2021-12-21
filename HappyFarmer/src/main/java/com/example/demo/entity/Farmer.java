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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name="farmer_job",joinColumns = @JoinColumn(name="farmer_id"),inverseJoinColumns = @JoinColumn(name="job_id"))
    private Set<Job> jobs=new HashSet<Job>();

    @ManyToMany(mappedBy = "farmers",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Society> societies=new HashSet<>();

    
}
