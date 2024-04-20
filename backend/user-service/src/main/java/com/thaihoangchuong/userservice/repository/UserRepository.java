package com.thaihoangchuong.userservice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>{

    Optional<User> findByName(String username);

}
