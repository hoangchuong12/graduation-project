package com.project.commodity.controller;

import com.project.commodity.payload.request.ProductTagRequest;
import com.project.commodity.payload.response.ProductTagResponse;
import com.project.commodity.service.ProductTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/PRODUCTS-SERVICE/api/product-tags")
@RequiredArgsConstructor
public class ProductTagController {

    private final ProductTagService productTagService;

    @PostMapping
    public ResponseEntity<UUID> addProductTag( @RequestBody ProductTagRequest request) {
        UUID productTagId = productTagService.addProductTag(request);
        return new ResponseEntity<>(productTagId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductTagResponse>> getAllProductTags() {
        List<ProductTagResponse> productTags = productTagService.getAllProductTags();
        return new ResponseEntity<>(productTags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTagResponse> getProductTagById(@PathVariable("id") UUID productTagId) {
        ProductTagResponse productTag = productTagService.getProductTagById(productTagId);
        return new ResponseEntity<>(productTag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTagResponse> editProductTag(@PathVariable("id") UUID productTagId,  @RequestBody ProductTagRequest request) {
        ProductTagResponse updatedProductTag = productTagService.editProductTag(productTagId, request);
        return new ResponseEntity<>(updatedProductTag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductTag(@PathVariable("id") UUID productTagId) {
        productTagService.deleteProductTagById(productTagId);
        return ResponseEntity.noContent().build();
    }
}
