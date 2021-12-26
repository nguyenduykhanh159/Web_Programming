package com.example.demo.entity.user;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerSocietyID implements Serializable {
    private static final long serialVersionUID = -8531790606923276999L;
    private int farmer_id;
    private int society_id;

}
