package com.project.commodity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commodity.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID>{

}
