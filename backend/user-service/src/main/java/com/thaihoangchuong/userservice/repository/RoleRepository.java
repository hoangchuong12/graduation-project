package com.thaihoangchuong.userservice.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.userservice.entity.Role;


public interface RoleRepository extends JpaRepository<Role, UUID> {

}

