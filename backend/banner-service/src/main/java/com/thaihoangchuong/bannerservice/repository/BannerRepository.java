package com.thaihoangchuong.bannerservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.bannerservice.entity.Banner;

public interface BannerRepository extends JpaRepository<Banner,UUID>{

}
