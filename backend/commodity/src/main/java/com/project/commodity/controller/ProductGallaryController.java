package com.project.commodity.controller;

import com.project.commodity.payload.request.ProductGallaryRequest;
import com.project.commodity.payload.response.ProductGallaryResponse;
import com.project.commodity.service.ProductGallaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-gallaries")
@RequiredArgsConstructor
public class ProductGallaryController {

    private final ProductGallaryService productGallaryService;

    @PostMapping
    public ResponseEntity<UUID> addProductGallary( @RequestBody ProductGallaryRequest request) {
        UUID productGallaryId = productGallaryService.addProductGallary(request);
        return new ResponseEntity<>(productGallaryId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductGallaryResponse>> getAllProductGallaries() {
        List<ProductGallaryResponse> productGallaries = productGallaryService.getAllProductGallarys();
        return new ResponseEntity<>(productGallaries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGallaryResponse> getProductGallaryById(@PathVariable("id") UUID productGallaryId) {
        ProductGallaryResponse productGallary = productGallaryService.getProductGallaryById(productGallaryId);
        return new ResponseEntity<>(productGallary, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductGallaryResponse> editProductGallary(@PathVariable("id") UUID productGallaryId, @RequestBody ProductGallaryRequest request) {
        ProductGallaryResponse updatedProductGallary = productGallaryService.editProductGallary(productGallaryId, request);
        return new ResponseEntity<>(updatedProductGallary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductGallary(@PathVariable("id") UUID productGallaryId) {
        productGallaryService.deleteProductGallaryById(productGallaryId);
        return ResponseEntity.noContent().build();
    }
}
