package com.thaihoangchuong.bannerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.thaihoangchuong.bannerservice.payload.request.SliderRequest;
import com.thaihoangchuong.bannerservice.payload.response.SliderResponse;
import com.thaihoangchuong.bannerservice.service.SliderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/BANNER-SERVICE/api/sliders")
public class SliderController {

    private final SliderService sliderService;

    public SliderController(SliderService sliderService) {
        this.sliderService = sliderService;
    }

    @PostMapping
    public ResponseEntity<UUID> addSlider(@RequestBody SliderRequest request) {
        UUID sliderId = sliderService.addSlider(request);
        return new ResponseEntity<>(sliderId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SliderResponse>> getAllSliders() {
        List<SliderResponse> allSliders = sliderService.getAllSliders();
        return new ResponseEntity<>(allSliders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SliderResponse> getSliderById(@PathVariable("id") UUID sliderId) {
        SliderResponse sliderResponse = sliderService.getSliderById(sliderId);
        return new ResponseEntity<>(sliderResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SliderResponse> editSlider(@PathVariable("id") UUID sliderId, @RequestBody SliderRequest request) {
        SliderResponse editedSlider = sliderService.editSlider(sliderId, request);
        return new ResponseEntity<>(editedSlider, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSliderById(@PathVariable("id") UUID sliderId) {
        sliderService.deleteSliderById(sliderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
