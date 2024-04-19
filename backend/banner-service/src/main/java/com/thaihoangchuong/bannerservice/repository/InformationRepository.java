package com.thaihoangchuong.bannerservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.bannerservice.entity.Information;

public interface InformationRepository extends JpaRepository<Information, UUID>{

}
