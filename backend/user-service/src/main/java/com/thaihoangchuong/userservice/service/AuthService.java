package com.thaihoangchuong.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thaihoangchuong.userservice.entity.User;
import com.thaihoangchuong.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @Autowired
    private JwtService jwtService;
   
    public String saveUser(User credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
         userRepository.save(credential);
        return "user added to the system";
    }   
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
