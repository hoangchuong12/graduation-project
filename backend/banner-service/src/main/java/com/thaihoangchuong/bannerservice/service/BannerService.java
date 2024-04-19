package com.thaihoangchuong.bannerservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.bannerservice.payload.request.BannerRequest;
import com.thaihoangchuong.bannerservice.payload.response.BannerResponse;

public interface BannerService {
    public UUID addBanner(BannerRequest BannerRequest);
    public List <BannerResponse> getAllBanners();
    public BannerResponse getBannerById (UUID BannerId);
    public BannerResponse editBanner(UUID BannerId, BannerRequest BannerRequest);
    public void deleteBannerById(UUID BannerId);
}
