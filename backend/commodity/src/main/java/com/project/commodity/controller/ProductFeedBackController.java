package com.project.commodity.controller;

import com.project.commodity.payload.request.ProductFeedBackRequest;
import com.project.commodity.payload.response.ProductFeedBackResponse;
import com.project.commodity.service.ProductFeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-feedbacks")
@RequiredArgsConstructor
public class ProductFeedBackController {

    private final ProductFeedBackService productFeedBackService;

    @PostMapping
    public ResponseEntity<UUID> addProductFeedBack( @RequestBody ProductFeedBackRequest request) {
        UUID productFeedBackId = productFeedBackService.addProductFeedBack(request);
        return new ResponseEntity<>(productFeedBackId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductFeedBackResponse>> getAllProductFeedBacks() {
        List<ProductFeedBackResponse> productFeedBacks = productFeedBackService.getAllProductFeedBacks();
        return new ResponseEntity<>(productFeedBacks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductFeedBackResponse> getProductFeedBackById(@PathVariable("id") UUID productFeedBackId) {
        ProductFeedBackResponse productFeedBack = productFeedBackService.getProductFeedBackById(productFeedBackId);
        return new ResponseEntity<>(productFeedBack, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductFeedBackResponse> editProductFeedBack(@PathVariable("id") UUID productFeedBackId,  @RequestBody ProductFeedBackRequest request) {
        ProductFeedBackResponse updatedProductFeedBack = productFeedBackService.editProductFeedBack(productFeedBackId, request);
        return new ResponseEntity<>(updatedProductFeedBack, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductFeedBack(@PathVariable("id") UUID productFeedBackId) {
        productFeedBackService.deleteProductFeedBackById(productFeedBackId);
        return ResponseEntity.noContent().build();
    }
}
