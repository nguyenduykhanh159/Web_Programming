package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="job")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name="name")
   private String name;

   @Column(name="fee")
   private float fee;

   @Column(name="description")
   private String description; 

   @Column(name="due")
   @Temporal(TemporalType.DATE)
   private Date due;

   //1 job is created by 1 farmer
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JsonIgnore
   @JoinColumn(name="owner_id")
    private Farmer owner;
  
    //1 job can have n contacts 
    @ManyToMany(mappedBy = "jobs")
    private Set<Farmer> workers=new HashSet<Farmer>();


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="workplace_id")
    private Workplace workplace;
}
