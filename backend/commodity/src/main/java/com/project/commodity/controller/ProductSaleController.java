package com.project.commodity.controller;

import com.project.commodity.payload.request.ProductSaleRequest;
import com.project.commodity.payload.response.ProductSaleResponse;
import com.project.commodity.service.ProductSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/productsales")
@RequiredArgsConstructor
public class ProductSaleController {

    private final ProductSaleService productSaleService;

    @PostMapping
    public ResponseEntity<UUID> addProductSale( @RequestBody ProductSaleRequest request) {
        UUID productSaleId = productSaleService.addProductSale(request);
        return new ResponseEntity<>(productSaleId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductSaleResponse>> getAllProductSales() {
        List<ProductSaleResponse> productSales = productSaleService.getAllProductSales();
        return new ResponseEntity<>(productSales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSaleResponse> getProductSaleById(@PathVariable("id") UUID productSaleId) {
        ProductSaleResponse productSale = productSaleService.getProductSaleById(productSaleId);
        return new ResponseEntity<>(productSale, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductSaleResponse> editProductSale(@PathVariable("id") UUID productSaleId, @RequestBody ProductSaleRequest request) {
        ProductSaleResponse updatedProductSale = productSaleService.editProductSale(productSaleId, request);
        return new ResponseEntity<>(updatedProductSale, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductSale(@PathVariable("id") UUID productSaleId) {
        productSaleService.deleteProductSaleById(productSaleId);
        return ResponseEntity.noContent().build();
    }
}
