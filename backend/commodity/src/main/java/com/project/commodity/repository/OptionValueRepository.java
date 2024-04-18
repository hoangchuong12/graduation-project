package com.project.commodity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commodity.entity.OptionValue;

public interface OptionValueRepository extends  JpaRepository<OptionValue, UUID>{

}
