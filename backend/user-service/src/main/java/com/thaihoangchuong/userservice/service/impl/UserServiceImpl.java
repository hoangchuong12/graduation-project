package com.thaihoangchuong.userservice.service.impl;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.thaihoangchuong.userservice.entity.User;
import com.thaihoangchuong.userservice.exception.CustomException;
import com.thaihoangchuong.userservice.payload.request.UserRequest;
import com.thaihoangchuong.userservice.payload.response.UserResponse;
import com.thaihoangchuong.userservice.payload.response.UserToServiceResponse;
import com.thaihoangchuong.userservice.repository.UserRepository;
import com.thaihoangchuong.userservice.service.JwtService;
import com.thaihoangchuong.userservice.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, 
    JwtService jwtService,
    PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService =jwtService;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        mapRequestToEntity(userRequest, user);
        user.setCreatedAt(LocalDateTime.now());

        // Hash password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User savedUser = userRepository.save(user);
        return mapEntityToResponse(savedUser);
    }

    @Override
    public UserResponse getById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found", "NOT_FOUND"));
        return mapEntityToResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse update(UUID id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found", "NOT_FOUND"));
        mapRequestToEntity(userRequest, user);
        user.setUpdatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return mapEntityToResponse(savedUser);
    }

    @Override
    public UserResponse delete(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found", "NOT_FOUND"));
        userRepository.delete(user);
        return mapEntityToResponse(user);
    }

    @Override
    public     UserToServiceResponse getUserForService(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found", "NOT_FOUND"));
        return mapUserToBrandResponse(user);
    }


    private void mapRequestToEntity(UserRequest userRequest, User user) {
        BeanUtils.copyProperties(userRequest, user);
    }
    

    private UserResponse mapEntityToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    private UserToServiceResponse mapUserToBrandResponse(User user) {
        UserToServiceResponse userToBrandResponse = new  UserToServiceResponse();
        BeanUtils.copyProperties(user, userToBrandResponse);
        return userToBrandResponse;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
