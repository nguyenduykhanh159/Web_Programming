package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "farmer_society")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerSociety {
   @EmbeddedId
   private FarmerSocietyID farmerSocietyID;

    @Column(name="joined_date")
    private Date joinedDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    @MapsId("farmer_id")
    private Farmer farmer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "society_id")
    @MapsId("society_id")
    private Society society;

}