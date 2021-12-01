package com.example.demo.model;

import java.util.Date;

public class CooperativeModel {

    private float totalCapital;
    private Date establishedDate;
    private String industryCode;

    public float getTotalCapital() {
        return this.totalCapital;
    }

    public void setTotalCapital(float totalCapital) {
        this.totalCapital = totalCapital;
    }

    public Date getEstablishedDate() {
        return this.establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getIndustryCode() {
        return this.industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }
}
