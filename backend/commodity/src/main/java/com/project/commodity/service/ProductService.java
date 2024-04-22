package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductRequest;
import com.project.commodity.payload.response.ProductResponse;

public interface ProductService {
    
    ProductResponse create(ProductRequest productRequest);
    
    ProductResponse getById(UUID id);
    
    List<ProductResponse> getAll();
    
    ProductResponse update(UUID id, ProductRequest productRequest);
    
    ProductResponse delete(UUID id);
    
    List<ProductResponse> findByBrandId(UUID brandId);
    
}
