package com.thaihoangchuong.bannerservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.bannerservice.payload.request.SliderRequest;
import com.thaihoangchuong.bannerservice.payload.response.SliderResponse;

public interface SliderService {
    public UUID addSlider(SliderRequest SliderRequest);
    public List <SliderResponse> getAllSliders();
    public SliderResponse getSliderById (UUID SliderId);
    public SliderResponse editSlider(UUID SliderId, SliderRequest SliderRequest);
    public void deleteSliderById(UUID SliderId);
}
