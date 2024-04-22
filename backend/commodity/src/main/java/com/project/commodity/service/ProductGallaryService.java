package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductGallaryRequest;
import com.project.commodity.payload.response.ProductGallaryResponse;

public interface ProductGallaryService {

    ProductGallaryResponse create(ProductGallaryRequest productGallaryRequest);

    ProductGallaryResponse getById(UUID id);

    List<ProductGallaryResponse> getAll();

    ProductGallaryResponse update(UUID id, ProductGallaryRequest productGallaryRequest);

    ProductGallaryResponse delete(UUID id);

    List<ProductGallaryResponse> findByProductId(UUID productId);
}
