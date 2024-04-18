package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductGallaryRequest;
import com.project.commodity.payload.response.ProductGallaryResponse;

public interface ProductGallaryService {
    public UUID addProductGallary(ProductGallaryRequest ProductGallaryRequest);
    public List <ProductGallaryResponse> getAllProductGallarys();
    public ProductGallaryResponse getProductGallaryById (UUID ProductGallaryId);
    public ProductGallaryResponse editProductGallary(UUID ProductGallaryId, ProductGallaryRequest ProductGallaryRequest);
    public void deleteProductGallaryById(UUID ProductGallaryId);

}
