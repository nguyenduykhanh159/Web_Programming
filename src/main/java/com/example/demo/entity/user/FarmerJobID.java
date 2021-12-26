package com.example.demo.entity.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerJobID implements Serializable {
    private static final long serialVersionUID = -8531790606923276999L;
      
    @Column(name="job_id")
    private int jobId;

    @Column(name="worker_id")
    private int workerId;

  

   
}