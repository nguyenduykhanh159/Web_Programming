package com.example.demo.dao;

import com.example.demo.entity.user.Society;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SocietyRepository extends JpaRepository<Society,Integer>{
    
}
