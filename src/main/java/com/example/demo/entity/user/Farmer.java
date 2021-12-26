package com.example.demo.entity.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.entity.Workplace;
import com.example.demo.entity.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity(name="farmer")
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
public class Farmer extends User {

    @Column(name="age")
    private int age;

    //1 farmer can have n workplaces
    @OneToMany(mappedBy = "farmer")
    private Set<Workplace> workplaces=new HashSet<Workplace>();

   
    //1 farmer do n jobs
    @OneToMany(mappedBy = "worker")
    @JsonIgnore
    private Set<FarmerJob> doJob=new HashSet<FarmerJob>();

    @OneToMany(mappedBy = "farmer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<FarmerSociety> societies=new HashSet<>();
   
}
