package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductOptionRequest;
import com.project.commodity.payload.response.ProductOptionResponse;

public interface ProductOptionService {
    
    ProductOptionResponse createProductOption(ProductOptionRequest productOptionRequest);

    List<ProductOptionResponse> getProductOptionsByProductId(UUID productId);

    List<ProductOptionResponse> getProductOptionsByOptionId(UUID optionId);

    void deleteProductOption(UUID productId, UUID optionId);

    void deleteProductOptionsByProductId(UUID productId);

    void deleteProductOptionsByOptionId(UUID optionId);

    List<ProductOptionResponse> getAllProductOptions();
}
