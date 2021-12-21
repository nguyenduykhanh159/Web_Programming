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

    @OneToMany(mappedBy = "society",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<FarmerSociety> farmers=new HashSet<>();


}
