package com.project.commodity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.commodity.payload.request.CategoryRequest;
import com.project.commodity.payload.response.CategoryResponse;
import com.project.commodity.service.CategoryService;

@RestController
@RequestMapping("/PRODUCTS-SERVICE/api/category")
@RequiredArgsConstructor
@Log4j2
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<UUID> adddCategory(@RequestBody CategoryRequest categoryRequest){
        log.info("CategoryCotroller | addcategory");
        UUID CategoryId = categoryService.addCategory(categoryRequest);

        return new ResponseEntity<>(CategoryId, HttpStatus.CREATED);
    }@GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") UUID CategoryId){
        CategoryResponse categoryResponse = categoryService.getCategoryById(CategoryId);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategoris() {
        List<CategoryResponse> categoryResponses = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryResponses); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> editCategory(@PathVariable("id") UUID CategoryId , CategoryRequest categoryRequest){
        categoryService.editCategory(CategoryId, categoryRequest);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") UUID CategoryId){
        categoryService.deleteCategoryById(CategoryId);
    }
}
