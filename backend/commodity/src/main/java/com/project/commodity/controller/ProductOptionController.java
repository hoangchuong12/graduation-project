package com.project.commodity.controller;

import com.project.commodity.payload.request.ProductOptionRequest;
import com.project.commodity.payload.response.ProductOptionResponse;
import com.project.commodity.service.ProductOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-options")
@RequiredArgsConstructor
public class ProductOptionController {

    private final ProductOptionService productOptionService;

    @PostMapping
    public ResponseEntity<UUID> addProductOption( @RequestBody ProductOptionRequest request) {
        UUID productOptionId = productOptionService.addProductOption(request);
        return new ResponseEntity<>(productOptionId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductOptionResponse>> getAllProductOptions() {
        List<ProductOptionResponse> productOptions = productOptionService.getAllProductOptions();
        return new ResponseEntity<>(productOptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOptionResponse> getProductOptionById(@PathVariable("id") UUID productOptionId) {
        ProductOptionResponse productOption = productOptionService.getProductOptionById(productOptionId);
        return new ResponseEntity<>(productOption, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOptionResponse> editProductOption(@PathVariable("id") UUID productOptionId,  @RequestBody ProductOptionRequest request) {
        ProductOptionResponse updatedProductOption = productOptionService.editProductOption(productOptionId, request);
        return new ResponseEntity<>(updatedProductOption, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductOption(@PathVariable("id") UUID productOptionId) {
        productOptionService.deleteProductOptionById(productOptionId);
        return ResponseEntity.noContent().build();
    }
    
}
