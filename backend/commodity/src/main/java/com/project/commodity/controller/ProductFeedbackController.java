package com.project.commodity.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.commodity.payload.request.ProductFeedbackRequest;
import com.project.commodity.payload.response.ProductFeedbackResponse;
import com.project.commodity.service.ProductFeedbackService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product-services/api/product-feedbacks")
public class ProductFeedbackController {

    private final ProductFeedbackService productFeedbackService;

    public ProductFeedbackController(ProductFeedbackService productFeedbackService) {
        this.productFeedbackService = productFeedbackService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductFeedbackResponse> createProductFeedback(@RequestBody ProductFeedbackRequest productFeedbackRequest) {
        ProductFeedbackResponse createdProductFeedback = productFeedbackService.create(productFeedbackRequest);
        return new ResponseEntity<>(createdProductFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductFeedbackResponse>> getAllProductFeedbacks() {
        List<ProductFeedbackResponse> productFeedbacks = productFeedbackService.getAll();
        return ResponseEntity.ok(productFeedbacks);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ProductFeedbackResponse> getProductFeedbackById(@PathVariable UUID id) {
        ProductFeedbackResponse productFeedback = productFeedbackService.getById(id);
        if (productFeedback != null) {
            return ResponseEntity.ok(productFeedback);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-product-id/{productId}")
    public ResponseEntity<List<ProductFeedbackResponse>> getProductFeedbacksByProductId(@PathVariable UUID productId) {
        List<ProductFeedbackResponse> productFeedbacks = productFeedbackService.findByProductId(productId);
        return ResponseEntity.ok(productFeedbacks);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductFeedbackResponse> updateProductFeedback(@RequestBody ProductFeedbackRequest productFeedbackRequest, @PathVariable UUID id) {
        ProductFeedbackResponse updatedProductFeedback = productFeedbackService.update(id, productFeedbackRequest);
        if (updatedProductFeedback != null) {
            return ResponseEntity.ok(updatedProductFeedback);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductFeedbackResponse> deleteProductFeedback(@PathVariable UUID id) {
        ProductFeedbackResponse deletedProductFeedback = productFeedbackService.delete(id);
        if (deletedProductFeedback != null) {
            return ResponseEntity.ok(deletedProductFeedback);
        }
        return ResponseEntity.notFound().build();
    }
}
