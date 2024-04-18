package com.project.commodity.controller;

import com.project.commodity.payload.request.ProductCategoryRequest;
import com.project.commodity.payload.response.ProductCategoryResponse;
import com.project.commodity.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Product_categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<UUID> addCategory( @RequestBody ProductCategoryRequest request) {
        UUID categoryId = productCategoryService.addProductCategory(request);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryResponse>> getAllCategories() {
        List<ProductCategoryResponse> categories = productCategoryService.getAllProductCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponse> getCategoryById(@PathVariable("id") UUID categoryId) {
        ProductCategoryResponse category = productCategoryService.getProductCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryResponse> editCategory(@PathVariable("id") UUID categoryId,  @RequestBody ProductCategoryRequest request) {
        ProductCategoryResponse updatedCategory = productCategoryService.editProductCategory(categoryId, request);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") UUID categoryId) {
        productCategoryService.deleteProductCategoryById(categoryId);
        return ResponseEntity.noContent().build();
    }
}
