package com.thaihoangchuong.bannerservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.bannerservice.payload.request.SliderRequest;
import com.thaihoangchuong.bannerservice.payload.response.SliderResponse;

public interface SliderService {
    SliderResponse create(SliderRequest SliderRequest);
    SliderResponse getById( UUID id);
    List<SliderResponse> getAll();
    SliderResponse update(UUID id , SliderRequest SliderRequest);
    SliderResponse delete(UUID id);
}
