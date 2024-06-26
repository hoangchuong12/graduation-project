package com.project.commodity.service.impl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.commodity.entity.Category;
import com.project.commodity.payload.request.CategoryRequest;
import com.project.commodity.payload.response.CategoryResponse;
import com.project.commodity.repository.CategoryRepository;
import com.project.commodity.service.CategoryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = new Category();
        mapRequestToEntity(categoryRequest, category);
        category.setCreatedAt(LocalDateTime.now());
        Category savedCategory = categoryRepository.save(category);
        return mapCategoryToCategoryResponse(savedCategory);
    }

    @Override
    public CategoryResponse getById(UUID id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return mapCategoryToCategoryResponse(category);
        }
        return null;
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::mapCategoryToCategoryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse update(UUID id, CategoryRequest categoryRequest) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            mapRequestToEntity(categoryRequest, existingCategory);
            existingCategory.setUpdatedAt(LocalDateTime.now());
            Category updatedCategory = categoryRepository.save(existingCategory);
            return mapCategoryToCategoryResponse(updatedCategory);
        }
        return null;
    }

    @Override
    public CategoryResponse delete(UUID id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            categoryRepository.delete(category);
            return mapCategoryToCategoryResponse(category);
        }
        return null;
    }

    private CategoryResponse mapCategoryToCategoryResponse(Category category) {
        if (category != null) {
            return CategoryResponse.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .image(category.getImage())
                    .productQuantity(category.getProductQuantity())
                    .description(category.getDescription())
                    .createdAt(category.getCreatedAt())
                    .updatedAt(category.getUpdatedAt())
                    .createdBy(category.getCreatedBy())
                    .updatedBy(category.getUpdatedBy())
                    .status(category.getStatus())
                    .build();
        }
        return null;
    }

    private void mapRequestToEntity(CategoryRequest categoryRequest, Category category) {
        BeanUtils.copyProperties(categoryRequest, category);
    }
}
