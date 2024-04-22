package com.thaihoangchuong.bannerservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.bannerservice.payload.request.BannerRequest;
import com.thaihoangchuong.bannerservice.payload.response.BannerResponse;

public interface BannerService {
    BannerResponse create(BannerRequest bannerRequest);
    BannerResponse getById( UUID id);
    List<BannerResponse> getAll();
    BannerResponse update(UUID id , BannerRequest bannerRequest);
    BannerResponse delete(UUID id);
}
