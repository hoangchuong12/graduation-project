package com.thaihoangchuong.bannerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thaihoangchuong.bannerservice.payload.request.BannerRequest;
import com.thaihoangchuong.bannerservice.payload.response.BannerResponse;
import com.thaihoangchuong.bannerservice.service.BannerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/BANNER-SERVICE/api/banners")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping
    public ResponseEntity<UUID> addBanner(@RequestBody BannerRequest request) {
        UUID bannerId = bannerService.addBanner(request);
        return new ResponseEntity<>(bannerId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BannerResponse>> getAllBanners() {
        List<BannerResponse> banners = bannerService.getAllBanners();
        return new ResponseEntity<>(banners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BannerResponse> getBannerById(@PathVariable UUID id) {
        BannerResponse banner = bannerService.getBannerById(id);
        return new ResponseEntity<>(banner, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BannerResponse> editBanner(@PathVariable UUID id, @RequestBody BannerRequest request) {
        BannerResponse editedBanner = bannerService.editBanner(id, request);
        return new ResponseEntity<>(editedBanner, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanner(@PathVariable UUID id) {
        bannerService.deleteBannerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

