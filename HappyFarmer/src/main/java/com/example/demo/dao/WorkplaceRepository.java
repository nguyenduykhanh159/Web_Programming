package com.example.demo.dao;

import com.example.demo.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
}