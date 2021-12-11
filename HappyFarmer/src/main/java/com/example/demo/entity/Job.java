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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="job")
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
    @OneToMany(mappedBy = "job")
    private Set<FarmerJob> contacts=new HashSet<FarmerJob>();


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="workplace_id")
    private Workplace workplace;

    public Date getDue() {
        return this.due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Farmer getOwner() {
        return this.owner;
    }

    public void setOwner(Farmer owner) {
        this.owner = owner;
    }

    public Set<FarmerJob> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<FarmerJob> contacts) {
        this.contacts = contacts;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFee() {
        return this.fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
