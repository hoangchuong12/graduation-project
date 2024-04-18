package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.BrandRequest;
import com.project.commodity.payload.response.BrandResponse;

public interface BrandService {


    public UUID addBrand(BrandRequest brandRequest);
    public List <BrandResponse> getAllBrands();
    public BrandResponse getBrandById (UUID BrandId);
    public BrandResponse editBrand(UUID BrandId, BrandRequest brandRequest);
    public void deleteBrandById(UUID BrandId);
}
