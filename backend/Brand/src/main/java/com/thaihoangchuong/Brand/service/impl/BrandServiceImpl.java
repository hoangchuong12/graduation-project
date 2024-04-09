package com.thaihoangchuong.Brand.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.thaihoangchuong.Brand.entity.Brand;
import com.thaihoangchuong.Brand.exception.BrandServiceCustomException;
import com.thaihoangchuong.Brand.payload.request.BrandRequest;
import com.thaihoangchuong.Brand.payload.response.BrandResponse;
import com.thaihoangchuong.Brand.repository.BrandRepository;
import com.thaihoangchuong.Brand.service.BrandService;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;

    @Override
    public long addBrand(BrandRequest brandRequest) {
        Brand brand= Brand.builder()
        .BrandName(brandRequest.getBrandName())
        .CreatedAt(brandRequest.getCreatedAt())
        .CreatedBy(brandRequest.getCreatedBy())
        .UpdatedAt(brandRequest.getUpdatedAt())
        .UpdatedBy(brandRequest.getUpdatedBy())
        .build();
        Brand BrandResponse = brandRepository.save(brand);
        return BrandResponse.getId();
    }

    @Override
    public List<BrandResponse> getAllBrand() {
        List<Brand> brands = brandRepository.findAll();

        List<BrandResponse> brandResponses = brands.stream()
        .map(brand -> {
            BrandResponse brandResponse =  new BrandResponse();
            BeanUtils.copyProperties(brand, brands);
            return brandResponse;
        })
        .collect(Collectors.toList());
        return brandResponses;
    }

    @Override
    public BrandResponse getBrandId(Integer BrandId) {
        Brand brand = brandRepository.findById(BrandId)
        .orElseThrow(
            () -> new BrandServiceCustomException("Brand with given id not  found" ,"Brand_not_found"));
            BrandResponse brandResponse =  new BrandResponse();

            BeanUtils.copyProperties(brand, brandResponse);
        return brandResponse;
    }

    @Override
    public BrandResponse edirBrand(Integer BrandId, BrandRequest brandRequest) {
        Brand brand = brandRepository.findById(BrandId)
        .orElseThrow(
            () -> new BrandServiceCustomException("Brand with given id not  found" ,"Brand_not_found"));
            brand.setBrandName(brandRequest.getBrandName());
            brand.setCreatedAt(brandRequest.getCreatedAt());
            brand.setCreatedBy(brandRequest.getCreatedBy());
            brand.setUpdatedAt(brandRequest.getUpdatedAt());
            brand.setUpdatedBy(brandRequest.getUpdatedBy());

            BrandResponse brandResponse = new BrandResponse();

            BeanUtils.copyProperties(brand, brandResponse);
            brandRepository.save(brand);
            return brandResponse;
    }

    @Override
    public void deleteBrandById(Integer BrandId) {
        log.info("brand id: {}", BrandId);
       brandRepository.deleteById(BrandId);

    }
    
} 