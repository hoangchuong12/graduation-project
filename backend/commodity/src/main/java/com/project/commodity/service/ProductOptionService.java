package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductOptionRequest;
import com.project.commodity.payload.response.ProductOptionResponse;

public interface ProductOptionService {
    public UUID addProductOption(ProductOptionRequest ProductOptionRequest);
    public List <ProductOptionResponse> getAllProductOptions();
    public ProductOptionResponse getProductOptionById (UUID ProductOptionId);
    public ProductOptionResponse editProductOption(UUID ProductOptionId, ProductOptionRequest ProductOptionRequest);
    public void deleteProductOptionById(UUID ProductOptionId);
}
