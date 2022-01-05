package com.example.demo.entity.user;

import java.util.Date;

import javax.persistence.*;

import com.example.demo.entity.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name="farmer_job")
@Data
public class FarmerJob {

    @EmbeddedId
    private FarmerJobID farmerJobID;

    @Column(name="received_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedAt;

    @Column(name="accepted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptedAt;

    @Column(name="deal_price")
    private Float dealPrice;

    @Column(name="comment")
    private String comment;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private FarmerJobStatus status;
    
    // 1 farmer can have n farmer job
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("worker_id")
    @JoinColumn(name = "worker_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Farmer worker;

    // 1 job can have n farmer job
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("job_id")
    @JoinColumn(name="job_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Job job;
}
