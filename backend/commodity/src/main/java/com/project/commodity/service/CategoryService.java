package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.CategoryRequest;
import com.project.commodity.payload.response.CategoryResponse;


public interface CategoryService {

    public UUID addCategory(CategoryRequest categoryRequest);
    public List <CategoryResponse> getAllCategories();
    public CategoryResponse getCategoryById (UUID CategoryId);
    public CategoryResponse editCategory(UUID CategoryId, CategoryRequest categoryRequest);
    public void deleteCategoryById(UUID CategoryId);
}
