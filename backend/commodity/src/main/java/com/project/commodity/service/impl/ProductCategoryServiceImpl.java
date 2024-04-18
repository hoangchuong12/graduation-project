package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.ProductCategory;
import com.project.commodity.exception.ProductCategoryServiceCusromException;
import com.project.commodity.payload.request.ProductCategoryRequest;
import com.project.commodity.payload.response.ProductCategoryResponse;
import com.project.commodity.repository.ProductCategoryRepository;
import com.project.commodity.service.ProductCategoryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public UUID addProductCategory(ProductCategoryRequest request) {
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(request, productCategory);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return savedProductCategory.getId();
    }

    @Override
    public List<ProductCategoryResponse> getAllProductCategories() {
        return productCategoryRepository.findAll().stream()
                .map(productCategory -> {
                    ProductCategoryResponse response = new ProductCategoryResponse();
                    BeanUtils.copyProperties(productCategory, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryResponse getProductCategoryById(UUID productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new ProductCategoryServiceCusromException("Product category with given ID not found", "product_category_not_found"));
        ProductCategoryResponse response = new ProductCategoryResponse();
        BeanUtils.copyProperties(productCategory, response);
        return response;
    }

    @Override
    public ProductCategoryResponse editProductCategory(UUID productCategoryId, ProductCategoryRequest request) {
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new ProductCategoryServiceCusromException("Product category with given ID not found", "product_category_not_found"));
        BeanUtils.copyProperties(request, productCategory);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        ProductCategoryResponse response = new ProductCategoryResponse();
        BeanUtils.copyProperties(savedProductCategory, response);
        return response;
    }

    @Override
    public void deleteProductCategoryById(UUID productCategoryId) {
        log.info("Deleting product category with ID: {}", productCategoryId);
        productCategoryRepository.deleteById(productCategoryId);
    }
}
