package com.project.commodity.service;


import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.BrandRequest;
import com.project.commodity.payload.response.BrandResponse;

public interface BrandService {

    BrandResponse create(BrandRequest brandRequest);

    BrandResponse getById(UUID id);

    List<BrandResponse> getAll();

    BrandResponse update(UUID id, BrandRequest brandRequest);

    BrandResponse delete(UUID id);

    List<BrandResponse> findByUser(UUID id);
}
