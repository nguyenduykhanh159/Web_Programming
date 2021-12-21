package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "farmer_society")
@Data
public class FarmerSociety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="joined_date")
    private LocalDateTime joinedDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "society_id")
    private Society society;

}