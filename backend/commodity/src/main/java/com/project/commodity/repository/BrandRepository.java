package com.project.commodity.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commodity.entity.Brand;



public interface BrandRepository extends JpaRepository<Brand, UUID>{

    List<Brand> findByCreatedBy(UUID createdBy);
}
