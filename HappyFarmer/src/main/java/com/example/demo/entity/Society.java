package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "society")
public class Society extends User{

    @Column(name = "total_capital")
    private float totalCapital;
    @Column(name="established_date")
    private LocalDate establishesDate;
    @Column(name="industry_code")
    private String industryCode;

    @OneToMany(mappedBy = "society",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<FarmerSociety> farmers=new HashSet<>();


    public Set<FarmerSociety> getFarmers() {
        return farmers;
    }

    public void setFarmers(Set<FarmerSociety> farmers) {
        this.farmers = farmers;
    }

    public float getTotalCapital() {
        return this.totalCapital;
    }

    public void setTotalCapital(float totalCapital) {
        this.totalCapital = totalCapital;
    }

    public LocalDate getEstablishesDate() {
        return this.establishesDate;
    }

    public void setEstablishesDate(LocalDate establishesDate) {
        this.establishesDate = establishesDate;
    }

    public String getIndustryCode() {
        return this.industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }
}
