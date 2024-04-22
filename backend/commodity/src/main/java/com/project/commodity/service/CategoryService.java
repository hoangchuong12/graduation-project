package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.CategoryRequest;
import com.project.commodity.payload.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse create(CategoryRequest categoryRequest);

    CategoryResponse getById(UUID id);

    List<CategoryResponse> getAll();

    CategoryResponse update(UUID id, CategoryRequest categoryRequest);

    CategoryResponse delete(UUID id);
}
