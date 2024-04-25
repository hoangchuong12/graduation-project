package com.thaihoangchuong.bannerservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.thaihoangchuong.bannerservice.entity.Banner;
import com.thaihoangchuong.bannerservice.payload.request.BannerRequest;
import com.thaihoangchuong.bannerservice.payload.response.BannerResponse;
import com.thaihoangchuong.bannerservice.repository.BannerRepository;
import com.thaihoangchuong.bannerservice.service.BannerService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public BannerResponse create(BannerRequest bannerRequest) {
        Banner banner = new Banner();
        mapRequestToEntity(bannerRequest, banner);
        banner.setCreatedAt(LocalDateTime.now());
        Banner savedBanner = bannerRepository.save(banner);
        return mapBannerToBannerResponse(savedBanner);
    }

    @Override
    public BannerResponse getById(UUID id) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        if (banner != null) {
            return mapBannerToBannerResponse(banner);
        }
        return null;
    }

    @Override
    public List<BannerResponse> getAll() {
        List<Banner> banners = bannerRepository.findAll();
        return banners.stream()
                .map(this::mapBannerToBannerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BannerResponse update(UUID id, BannerRequest bannerRequest) {
        Banner existingBanner = bannerRepository.findById(id).orElse(null);
        if (existingBanner != null) {
            mapRequestToEntity(bannerRequest, existingBanner);
            Banner updatedBanner = bannerRepository.save(existingBanner);
            return mapBannerToBannerResponse(updatedBanner);
        }
        return null;
    }

    @Override
    public BannerResponse delete(UUID id) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        if (banner != null) {
            bannerRepository.delete(banner);
            return mapBannerToBannerResponse(banner);
        }
        return null;
    }

    private BannerResponse mapBannerToBannerResponse(Banner banner) {
        if (banner != null) {
            return BannerResponse.builder()
                    .id(banner.getId())
                    .Name(banner.getName())
                    .image(banner.getImage())
                    .Description(banner.getDescription())
                    .CreatedAt(banner.getCreatedAt())
                    .UpdatedAt(banner.getUpdatedAt())
                    .CreatedBy(banner.getCreatedBy())
                    .UpdatedBy(banner.getUpdatedBy())
                    .build();
        }
        return null;
    }
    
    private void mapRequestToEntity(BannerRequest bannerRequest, Banner banner) {
        BeanUtils.copyProperties(bannerRequest, banner);
    }
}
