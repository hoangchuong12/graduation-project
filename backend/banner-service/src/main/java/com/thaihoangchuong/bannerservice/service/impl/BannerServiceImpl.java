package com.thaihoangchuong.bannerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.thaihoangchuong.bannerservice.entity.Banner;
import com.thaihoangchuong.bannerservice.exception.BannerServiceCustomException;
import com.thaihoangchuong.bannerservice.payload.request.BannerRequest;
import com.thaihoangchuong.bannerservice.payload.response.BannerResponse;
import com.thaihoangchuong.bannerservice.repository.BannerRepository;
import com.thaihoangchuong.bannerservice.service.BannerService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public UUID addBanner(BannerRequest request) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(request, banner);
        Banner savedBanner = bannerRepository.save(banner);
        return savedBanner.getId();
    }

    @Override
    public List<BannerResponse> getAllBanners() {
        return bannerRepository.findAll().stream()
                .map(banner -> {
                    BannerResponse response = new BannerResponse();
                    BeanUtils.copyProperties(banner, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BannerResponse getBannerById(UUID bannerId) {
        Banner banner = bannerRepository.findById(bannerId)
                .orElseThrow(() -> new BannerServiceCustomException("Banner with given ID not found", "banner_not_found"));
        BannerResponse response = new BannerResponse();
        BeanUtils.copyProperties(banner, response);
        return response;
    }

    @Override
    public BannerResponse editBanner(UUID bannerId, BannerRequest request) {
        Banner banner = bannerRepository.findById(bannerId)
                .orElseThrow(() -> new BannerServiceCustomException("Banner with given ID not found", "banner_not_found"));
        BeanUtils.copyProperties(request, banner);
        Banner savedBanner = bannerRepository.save(banner);
        BannerResponse response = new BannerResponse();
        BeanUtils.copyProperties(savedBanner, response);
        return response;
    }

    @Override
    public void deleteBannerById(UUID bannerId) {
        log.info("Deleting banner with ID: {}", bannerId);
        bannerRepository.deleteById(bannerId);
    }
}
