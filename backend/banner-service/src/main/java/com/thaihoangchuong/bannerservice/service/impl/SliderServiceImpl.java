package com.thaihoangchuong.bannerservice.service.impl;

import com.thaihoangchuong.bannerservice.entity.Slider;
import com.thaihoangchuong.bannerservice.payload.request.SliderRequest;
import com.thaihoangchuong.bannerservice.payload.response.SliderResponse;
import com.thaihoangchuong.bannerservice.repository.SliderRepository;
import com.thaihoangchuong.bannerservice.service.SliderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SliderServiceImpl implements SliderService {

    private final SliderRepository sliderRepository;

    public SliderServiceImpl(SliderRepository sliderRepository) {
        this.sliderRepository = sliderRepository;
    }

    @Override
    public SliderResponse create(SliderRequest sliderRequest) {
        Slider slider = new Slider();
        mapRequestToEntity(sliderRequest, slider);
        slider.setCreatedAt(LocalDateTime.now());
        Slider savedSlider = sliderRepository.save(slider);
        return mapSliderToSliderResponse(savedSlider);
    }

    @Override
    public SliderResponse getById(UUID id) {
        Slider slider = sliderRepository.findById(id).orElse(null);
        if (slider != null) {
            return mapSliderToSliderResponse(slider);
        }
        return null;
    }

    @Override
    public List<SliderResponse> getAll() {
        List<Slider> sliders = sliderRepository.findAll();
        return sliders.stream()
                .map(this::mapSliderToSliderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SliderResponse update(UUID id, SliderRequest sliderRequest) {
        Slider existingSlider = sliderRepository.findById(id).orElse(null);
        if (existingSlider != null) {
            mapRequestToEntity(sliderRequest, existingSlider);
            existingSlider.setCreatedAt(LocalDateTime.now());
            Slider updatedSlider = sliderRepository.save(existingSlider);
            return mapSliderToSliderResponse(updatedSlider);
        }
        return null;
    }

    @Override
    public SliderResponse delete(UUID id) {
        Slider slider = sliderRepository.findById(id).orElse(null);
        if (slider != null) {
            sliderRepository.delete(slider);
            return mapSliderToSliderResponse(slider);
        }
        return null;
    }

    private SliderResponse mapSliderToSliderResponse(Slider slider) {
        if (slider != null) {
            return SliderResponse.builder()
                    .id(slider.getId())
                    .Name(slider.getName())
                    .Image(slider.getImage())
                    .CreatedAt(slider.getCreatedAt())
                    .UpdatedAt(slider.getUpdatedAt())
                    .CreatedBy(slider.getCreatedBy())
                    .UpdatedBy(slider.getUpdatedBy())
                    .build();
        }
        return null;
    }

    private void mapRequestToEntity(SliderRequest sliderRequest, Slider slider) {
        BeanUtils.copyProperties(sliderRequest, slider);
    }
}
