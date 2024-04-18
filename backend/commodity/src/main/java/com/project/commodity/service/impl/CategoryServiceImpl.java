package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.Category;
import com.project.commodity.exception.CategoryServiceCustomException;
import com.project.commodity.payload.request.CategoryRequest;
import com.project.commodity.payload.response.CategoryResponse;
import com.project.commodity.repository.CategoryRepository;
import com.project.commodity.service.CategoryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public UUID addCategory(CategoryRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        Category savedCategory = categoryRepository.save(category);
        return savedCategory.getId();
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> {
                    CategoryResponse response = new CategoryResponse();
                    BeanUtils.copyProperties(category, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategoryById(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryServiceCustomException("Category with given ID not found", "category_not_found"));
        
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setImage(category.getImage());
        response.setDesciption(category.getDesciption());
        response.setCreatedAt(category.getCreatedAt());
        response.setUpdatedAt(category.getUpdatedAt());
        response.setCreatedBy(category.getCreatedBy());
        response.setUpdatedBy(category.getUpdatedBy());
        response.setStatus(category.getStatus());
    
        // Assign parentCategory directly if it exists
        if (category.getParentCategory() != null) {
            // Đặt trực tiếp đối tượng Category cho parentCategory của response
            response.setParentCategory(category.getParentCategory());
        }
    
        return response;
    }
    
    

    @Override
    public CategoryResponse editCategory(UUID categoryId, CategoryRequest request) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryServiceCustomException("Category with given ID not found", "category_not_found"));
        BeanUtils.copyProperties(request, category);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponse response = new CategoryResponse();
        BeanUtils.copyProperties(savedCategory, response);
        return response;
    }

    @Override
    public void deleteCategoryById(UUID categoryId) {
        log.info("Deleting category with ID: {}", categoryId);
        categoryRepository.deleteById(categoryId);
    }
}
