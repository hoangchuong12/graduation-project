package com.project.commodity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.commodity.payload.request.BrandRequest;
import com.project.commodity.payload.response.BrandResponse;
import com.project.commodity.service.BrandService;



@RestController
@RequestMapping("/PRODUCTS-SERVICE/api/brand")
@RequiredArgsConstructor
@Log4j2
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<UUID> addBrand(@RequestBody BrandRequest brandRequest){
        log.info("BrandCotroller | addBrand");
        UUID BrandId = brandService.addBrand(brandRequest);

        return new ResponseEntity<>(BrandId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable("id") UUID BrandId){
        BrandResponse brandResponse = brandService.getBrandById(BrandId);
        return new ResponseEntity<>(brandResponse, HttpStatus.OK);
    }
    @GetMapping("/brands")
    public ResponseEntity<List<BrandResponse>> getAllBenners() {
        List<BrandResponse> brandResponses = brandService.getAllBrands();
        return ResponseEntity.ok(brandResponses); 
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BrandResponse> editBrand(@PathVariable("id") UUID BrandId , BrandRequest brandRequest){
        brandService.editBrand(BrandId, brandRequest);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBrandById(@PathVariable("id") UUID BrandId){
        brandService.deleteBrandById(BrandId);
    }
}
