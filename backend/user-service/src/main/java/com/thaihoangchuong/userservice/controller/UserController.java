package com.thaihoangchuong.userservice.controller;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.thaihoangchuong.userservice.payload.request.AuthRequest;
import com.thaihoangchuong.userservice.payload.request.UserRequest;
import com.thaihoangchuong.userservice.payload.response.UserResponse;
import com.thaihoangchuong.userservice.payload.response.UserToServiceResponse;
import com.thaihoangchuong.userservice.service.UserService;

import org.springframework.security.core.Authentication;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user-services/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse createdUser = userService.create(userRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        UserResponse user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable UUID id) {
        UserResponse updatedUser = userService.update(id, userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable UUID id) {
        UserResponse deletedUser = userService.delete(id);
        return ResponseEntity.ok(deletedUser);
    }

    @GetMapping("/get-user-for-brand/{id}")
    public ResponseEntity<UserToServiceResponse> getUserForBrand(@PathVariable UUID id) {
        UserToServiceResponse userForBrand = userService.getUserForService(id);
        return ResponseEntity.ok(userForBrand);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
        return "Token is valid";
    }
}
