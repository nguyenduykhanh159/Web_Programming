package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="farmer_job")
public class FarmerJob {

    @EmbeddedId
    private FarmerJobID farmerJobID;
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    // 1 farmer can have n farmer job
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("worker_id")
    @JoinColumn(name = "worker_id")
    private Farmer worker;

    // 1 job can have n farmer job
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("job_id")
    @JoinColumn(name="job_id")
    private Job job;




    public FarmerJobID getFarmerJobID() {
        return farmerJobID;
    }

    public void setFarmerJobID(FarmerJobID farmerJobID) {
        this.farmerJobID = farmerJobID;
    }

    public Farmer getWorker() {
        return this.worker;
    }

    public void setWorker(Farmer worker) {
        this.worker = worker;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }


    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
