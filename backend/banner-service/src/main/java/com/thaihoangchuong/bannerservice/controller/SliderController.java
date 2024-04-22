package com.thaihoangchuong.bannerservice.controller;

import com.thaihoangchuong.bannerservice.payload.request.SliderRequest;
import com.thaihoangchuong.bannerservice.payload.response.SliderResponse;
import com.thaihoangchuong.bannerservice.service.SliderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("banner-services/api/sliders")
public class SliderController {

    private final SliderService sliderService;

    public SliderController(SliderService sliderService) {
        this.sliderService = sliderService;
    }

    @PostMapping("/create")
    public ResponseEntity<SliderResponse> createSlider(@RequestBody SliderRequest sliderRequest) {
        SliderResponse createdSlider = sliderService.create(sliderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSlider);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<SliderResponse> getSliderById(@PathVariable UUID id) {
        SliderResponse sliderResponse = sliderService.getById(id);
        if (sliderResponse != null) {
            return ResponseEntity.ok(sliderResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<SliderResponse>> getAllSliders() {
        List<SliderResponse> sliderResponses = sliderService.getAll();
        return ResponseEntity.ok(sliderResponses);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SliderResponse> updateSlider(@PathVariable UUID id, @RequestBody SliderRequest sliderRequest) {
        SliderResponse updatedSlider = sliderService.update(id, sliderRequest);
        if (updatedSlider != null) {
            return ResponseEntity.ok(updatedSlider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SliderResponse> deleteSlider(@PathVariable UUID id) {
        SliderResponse deletedSlider = sliderService.delete(id);
        if (deletedSlider != null) {
            return ResponseEntity.ok(deletedSlider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
