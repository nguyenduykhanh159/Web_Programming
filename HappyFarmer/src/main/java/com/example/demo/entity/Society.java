package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "society")
@Data
public class Society extends User{

    @Column(name = "total_capital")
    private float totalCapital;
    @Column(name="established_date")
    @Temporal(TemporalType.DATE)
    private Date establishesDate;
    @Column(name="industry_code")
    private String industryCode;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="farmer_society",joinColumns = @JoinColumn(name="society_id"),inverseJoinColumns = @JoinColumn(name="farmer_id"))
    private Set<Farmer> farmers=new HashSet<>();


}
