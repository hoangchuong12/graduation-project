package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductTagRequest;
import com.project.commodity.payload.response.ProductTagResponse;

public interface ProductTagService {

    ProductTagResponse create(ProductTagRequest productTagRequest);

    List<ProductTagResponse> getProductTagsByProductId(UUID productId);

    List<ProductTagResponse> getProductTagsByTagId(UUID tagId);

    void delete(UUID productId, UUID tagId);

    void deleteProductTagsByProductId(UUID productId);

    void deleteProductTagsByTagId(UUID tagId);

    List<ProductTagResponse> getAllProductTags();
}
