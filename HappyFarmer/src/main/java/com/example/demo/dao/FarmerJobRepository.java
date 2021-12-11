package com.example.demo.dao;

import com.example.demo.entity.FarmerJob;
import com.example.demo.entity.FarmerJobID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerJobRepository extends JpaRepository<FarmerJob, FarmerJobID> {
}