package com.example.demo.dao;

import com.example.demo.entity.notification.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    
}
