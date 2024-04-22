package com.thaihoangchuong.userservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.thaihoangchuong.userservice.entity.Notification;
import com.thaihoangchuong.userservice.exception.CustomException;
import com.thaihoangchuong.userservice.payload.request.NotificationRequest;
import com.thaihoangchuong.userservice.payload.response.NotificationResponse;
import com.thaihoangchuong.userservice.repository.NotificationRepository;
import com.thaihoangchuong.userservice.service.NotificationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationResponse create(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        mapRequestToEntity(notificationRequest, notification);
        notification.setCreatedAt(LocalDateTime.now());
        Notification savedNotification = notificationRepository.save(notification);
        return mapEntityToResponse(savedNotification);
    }

    @Override
    public NotificationResponse getById(UUID id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new CustomException("Notification not found", "NOT_FOUND"));
        return mapEntityToResponse(notification);
    }

    @Override
    public List<NotificationResponse> getAll() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationResponse update(UUID id, NotificationRequest notificationRequest) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new CustomException("Notification not found", "NOT_FOUND"));
        mapRequestToEntity(notificationRequest, notification);
        notification.setCreatedAt(LocalDateTime.now());
        Notification savedNotification = notificationRepository.save(notification);
        return mapEntityToResponse(savedNotification);
    }

    @Override
    public NotificationResponse delete(UUID id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new CustomException("Notification not found", "NOT_FOUND"));
        notificationRepository.delete(notification);
        return mapEntityToResponse(notification);
    }

    @Override
    public List<NotificationResponse> getByUser(UUID userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        return notifications.stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    private void mapRequestToEntity(NotificationRequest notificationRequest, Notification notification) {
        BeanUtils.copyProperties(notificationRequest, notification);
    }

    private NotificationResponse mapEntityToResponse(Notification notification) {
        NotificationResponse notificationResponse = new NotificationResponse();
        BeanUtils.copyProperties(notification, notificationResponse);
        return notificationResponse;
    }
}
