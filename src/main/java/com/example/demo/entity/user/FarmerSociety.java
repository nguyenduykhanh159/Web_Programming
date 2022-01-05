package com.example.demo.entity.user;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Farmer farmer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "society_id")
    @MapsId("society_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Society society;

}