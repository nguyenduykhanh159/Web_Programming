package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="farmer_job")
@Data
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
}
