package com.thaihoangchuong.bannerservice.controller;

import com.thaihoangchuong.bannerservice.payload.request.BannerRequest;
import com.thaihoangchuong.bannerservice.payload.response.BannerResponse;
import com.thaihoangchuong.bannerservice.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("banner-services/api/banners")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping("/create")
    public ResponseEntity<BannerResponse> createBanner(@RequestBody BannerRequest bannerRequest) {
        BannerResponse createdBanner = bannerService.create(bannerRequest);
        return new ResponseEntity<>(createdBanner, HttpStatus.CREATED);
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<BannerResponse> getBannerById(@PathVariable UUID id) {
        BannerResponse bannerResponse = bannerService.getById(id);
        if (bannerResponse != null) {
            return ResponseEntity.ok(bannerResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BannerResponse>> getAllBanners() {
        List<BannerResponse> bannerResponses = bannerService.getAll();
        return ResponseEntity.ok(bannerResponses);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BannerResponse> updateBanner(@PathVariable UUID id, @RequestBody BannerRequest bannerRequest) {
        BannerResponse updatedBanner = bannerService.update(id, bannerRequest);
        if (updatedBanner != null) {
            return ResponseEntity.ok(updatedBanner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BannerResponse> deleteBanner(@PathVariable UUID id) {
        BannerResponse deletedBanner = bannerService.delete(id);
        if (deletedBanner != null) {
            return ResponseEntity.ok(deletedBanner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
