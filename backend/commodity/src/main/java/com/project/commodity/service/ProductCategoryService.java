package com.project.commodity.service;




import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductCategoryRequest;
import com.project.commodity.payload.response.ProductCategoryResponse;

public interface ProductCategoryService {
    public UUID addProductCategory(ProductCategoryRequest ProductCategoryRequest);
    public List <ProductCategoryResponse> getAllProductCategories();
    public ProductCategoryResponse getProductCategoryById (UUID ProductCategoryId);
    public ProductCategoryResponse editProductCategory(UUID ProductCategoryId, ProductCategoryRequest ProductCategoryRequest);
    public void deleteProductCategoryById(UUID ProductCategoryId);
}
