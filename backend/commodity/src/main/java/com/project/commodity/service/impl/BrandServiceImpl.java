package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.Brand;
import com.project.commodity.exception.BrandServiceCustomException;
import com.project.commodity.payload.request.BrandRequest;
import com.project.commodity.payload.response.BrandResponse;
import com.project.commodity.repository.BrandRepository;
import com.project.commodity.service.BrandService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public UUID addBrand(BrandRequest request) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(request, brand);
        Brand savedBrand = brandRepository.save(brand);
        return savedBrand.getId();
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brand -> {
                    BrandResponse response = new BrandResponse();
                    BeanUtils.copyProperties(brand, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BrandResponse getBrandById(UUID brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandServiceCustomException("Brand with given ID not found", "brand_not_found"));
        BrandResponse response = new BrandResponse();
        BeanUtils.copyProperties(brand, response);
        return response;
    }

    @Override
    public BrandResponse editBrand(UUID brandId, BrandRequest brandRequest) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandServiceCustomException("Brand with given ID not found", "brand_not_found"));

        brand.setBrandName(brandRequest.getBrandName());
        brand.setImage(brandRequest.getImage());
        brand.setDesciption(brandRequest.getDesciption());
        brand.setTitle(brandRequest.getTitle());
        brand.setAddress(brandRequest.getAddress());
        brand.setCreatedAt(brandRequest.getCreatedAt());
        brand.setUpdatedAt(brandRequest.getUpdatedAt());
        brand.setCreatedBy(brandRequest.getCreatedBy());
        brand.setUpdatedBy(brandRequest.getUpdatedBy());
        brand.setStatus(brandRequest.getStatus());

        BrandResponse brandResponse = new BrandResponse();
        brandRepository.save(brand);
        return brandResponse;
    }


    @Override
    public void deleteBrandById(UUID brandId) {
        log.info("Deleting brand with ID: {}", brandId);
        brandRepository.deleteById(brandId);
    }
}
