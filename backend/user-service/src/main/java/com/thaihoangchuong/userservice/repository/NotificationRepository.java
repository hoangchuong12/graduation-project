package com.thaihoangchuong.userservice.repository;


import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.userservice.entity.Notification;



public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    
    List<Notification> findByUserId(UUID userId);

}
