package com.example.demo.entity.job;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.entity.Workplace;
import com.example.demo.entity.user.Farmer;
import com.example.demo.entity.user.FarmerJob;
import com.example.demo.entity.user.User;
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

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "address")
    private String address;

    @Column(name="create_at")
   @Temporal(TemporalType.DATE)
   private Date createAt;

   @Column(name="salary")
   private float salary;

   @Column(name = "contact")
   private String contact;

   @Column(name = "contact_number")
   private String contactNumber;

   @Column(name="description")
   private String description; 

   @Column(name = "job_detail")
   private String jobDetail;

   @Column(name="due")
   @Temporal(TemporalType.DATE)
   private Date due;
 
   @Column(name="status")
   @Enumerated(EnumType.STRING)
   private JobStatus jobStatus;

   //1 job is created by 1 farmer
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JsonIgnore
   @JoinColumn(name="owner_id")
    private User owner;
  
    //1 job can have n contacts 
    @OneToMany(mappedBy = "job")
    private Set<FarmerJob> contacts=new HashSet<FarmerJob>();


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="workplace_id")
    private Workplace workplace;
}
