package com.project.commodity.service;
import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.response.ProductCategoryResponse;

public interface ProductCategoryService {

    ProductCategoryResponse createProductCategory(UUID productId, UUID categoryId);

    List<ProductCategoryResponse> getProductCategoriesByProductId(UUID productId);

    List<ProductCategoryResponse> getProductCategoriesByCategoryId(UUID categoryId);

    void deleteProductCategory(UUID productId, UUID categoryId);

    void deleteProductCategoriesByProductId(UUID productId);

    void deleteProductCategoriesByCategoryId(UUID categoryId);

    List<ProductCategoryResponse> getAllProductCategories();
}
