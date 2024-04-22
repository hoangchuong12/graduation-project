package com.thaihoangchuong.userservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.userservice.payload.request.UserRequest;
import com.thaihoangchuong.userservice.payload.response.UserResponse;
import com.thaihoangchuong.userservice.payload.response.UserToServiceResponse;



public interface UserService {

    UserResponse create(UserRequest userRequest);

    UserResponse getById(UUID id);

    List<UserResponse> getAll();
    
    UserResponse update(UUID id, UserRequest roleRequest);

    UserResponse delete(UUID id);

    UserToServiceResponse getUserForService(UUID id);

    String generateToken(String username);

    void validateToken(String token);
}
