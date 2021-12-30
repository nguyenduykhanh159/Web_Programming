package com.example.demo.entity.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.entity.Workplace;
import com.example.demo.entity.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name="farmer")
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
public class Farmer extends User {

    @Column(name="age")
    private int age;

    //1 farmer can have n workplaces
    @OneToMany(mappedBy = "farmer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Workplace> workplaces;

   
    //1 farmer do n jobs
   

    @OneToMany(mappedBy = "farmer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<FarmerSociety> societies;
   
}
