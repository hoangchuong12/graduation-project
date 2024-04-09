package com.thaihoangchuong.Brand.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thaihoangchuong.Brand.payload.request.BrandRequest;
import com.thaihoangchuong.Brand.payload.response.BrandResponse;
import com.thaihoangchuong.Brand.service.BrandService;


@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
@Log4j2
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<Long> addBrand(@RequestBody BrandRequest brandRequest){
        log.info("BrandCotroller | addBrand");
        long BrandId = brandService.addBrand(brandRequest);

        return new ResponseEntity<>(BrandId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable("id") Integer BrandId){
        BrandResponse brandResponse = brandService.getBrandId(BrandId);
        return new ResponseEntity<>(brandResponse, HttpStatus.OK);
    }
    @GetMapping("/brands")
    public ResponseEntity<List<BrandResponse>> getAllBenners() {
        List<BrandResponse> brandResponses = brandService.getAllBrand();
        return ResponseEntity.ok(brandResponses); 
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BrandResponse> editBrand(@PathVariable("id") Integer BrandId , BrandRequest brandRequest){
        brandService.edirBrand(BrandId, brandRequest);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBrandById(@PathVariable("id") Integer BrandId){
        brandService.deleteBrandById(BrandId);
    }
}
