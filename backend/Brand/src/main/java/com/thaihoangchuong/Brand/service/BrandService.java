package com.thaihoangchuong.Brand.service;
import java.util.List;

import com.thaihoangchuong.Brand.payload.request.BrandRequest;
import com.thaihoangchuong.Brand.payload.response.BrandResponse;
public interface BrandService {


    public long addBrand(BrandRequest brandRequest);
    public List <BrandResponse> getAllBrand();
    public BrandResponse getBrandId (Integer BrandId);
    public BrandResponse edirBrand(Integer BrandId, BrandRequest brandRequest);
    public void deleteBrandById(Integer BrandId);
}
