package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductTagRequest;
import com.project.commodity.payload.response.ProductTagResponse;

public interface ProductTagService {
    public UUID addProductTag(ProductTagRequest ProductTagRequest);
    public List <ProductTagResponse> getAllProductTags();
    public ProductTagResponse getProductTagById (UUID ProductTagId);
    public ProductTagResponse editProductTag(UUID ProductTagId, ProductTagRequest ProductTagRequest);
    public void deleteProductTagById(UUID ProductTagId);

}
