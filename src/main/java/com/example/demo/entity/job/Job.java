package com.example.demo.entity.job;

import java.util.Collection;
import java.util.Date;


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
import com.example.demo.entity.user.FarmerJob;
import com.example.demo.entity.user.User;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "job")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "address")
    private String address;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "salary")
    private float salary;

    @Column(name = "contact")
    private String contact;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "due")
    @Temporal(TemporalType.DATE)
    private Date due;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    // 1 job is created by 1 farmer
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User owner;

    // 1 job can have n contacts
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<FarmerJob> contacts;;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "workplace_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Workplace workplace;
}
