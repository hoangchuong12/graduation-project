package com.thaihoangchuong.bannerservice.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.thaihoangchuong.bannerservice.entity.Slider;
import com.thaihoangchuong.bannerservice.exception.SliderServiceCustomException;
import com.thaihoangchuong.bannerservice.payload.request.SliderRequest;
import com.thaihoangchuong.bannerservice.payload.response.SliderResponse;
import com.thaihoangchuong.bannerservice.repository.SliderRepository;
import com.thaihoangchuong.bannerservice.service.SliderService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class SliderServiceImpl implements SliderService {

    private final SliderRepository sliderRepository;

    @Override
    public UUID addSlider(SliderRequest request) {
        Slider slider = new Slider();
        BeanUtils.copyProperties(request, slider);
        Slider savedSlider = sliderRepository.save(slider);
        return savedSlider.getId();
    }

    @Override
    public List<SliderResponse> getAllSliders() {
        return sliderRepository.findAll().stream()
                .map(slider -> {
                    SliderResponse response = new SliderResponse();
                    BeanUtils.copyProperties(slider, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public SliderResponse getSliderById(UUID sliderId) {
        Slider slider = sliderRepository.findById(sliderId)
                .orElseThrow(() -> new SliderServiceCustomException("Slider with given ID not found", "slider_not_found"));
        SliderResponse response = new SliderResponse();
        BeanUtils.copyProperties(slider, response);
        return response;
    }

    @Override
    public SliderResponse editSlider(UUID sliderId, SliderRequest request) {
        Slider slider = sliderRepository.findById(sliderId)
                .orElseThrow(() -> new SliderServiceCustomException("Slider with given ID not found", "slider_not_found"));
        BeanUtils.copyProperties(request, slider);
        Slider savedSlider = sliderRepository.save(slider);
        SliderResponse response = new SliderResponse();
        BeanUtils.copyProperties(savedSlider, response);
        return response;
    }

    @Override
    public void deleteSliderById(UUID sliderId) {
        log.info("Deleting slider with ID: {}", sliderId);
        sliderRepository.deleteById(sliderId);
    }
}
