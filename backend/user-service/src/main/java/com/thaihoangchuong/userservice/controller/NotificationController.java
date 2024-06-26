package com.thaihoangchuong.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thaihoangchuong.userservice.payload.request.NotificationRequest;
import com.thaihoangchuong.userservice.payload.response.NotificationResponse;
import com.thaihoangchuong.userservice.service.NotificationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user-services/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody NotificationRequest notificationRequest) {
        NotificationResponse createdNotification = notificationService.create(notificationRequest);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<NotificationResponse> getNotificationById(@PathVariable UUID id) {
        NotificationResponse notification = notificationService.getById(id);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {
        List<NotificationResponse> notifications = notificationService.getAll();
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NotificationResponse> updateNotification(@RequestBody NotificationRequest notificationRequest, @PathVariable UUID id) {
        NotificationResponse updatedNotification = notificationService.update(id, notificationRequest);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NotificationResponse> deleteNotification(@PathVariable UUID id) {
        NotificationResponse deletedNotification = notificationService.delete(id);
        return ResponseEntity.ok(deletedNotification);
    }

    @GetMapping("/get-by-user/{userId}")
    public ResponseEntity<List<NotificationResponse>> getNotificationsByUser(@PathVariable UUID userId) {
        List<NotificationResponse> notifications = notificationService.getByUser(userId);
        return ResponseEntity.ok(notifications);
    }
}
