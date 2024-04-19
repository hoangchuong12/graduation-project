package com.project.commodity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.commodity.payload.request.CouponRequest;
import com.project.commodity.payload.response.CouponResponse;
import com.project.commodity.service.CouponService;

@RestController
@RequestMapping("/PRODUCTS-SERVICE/api/coupon")
@RequiredArgsConstructor
@Log4j2
public class CouponController {
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<UUID> adddCoupon(@RequestBody CouponRequest CouponRequest){
        log.info("CouponCotroller | addCoupon");
        UUID CouponId = couponService.addCoupon(CouponRequest);

        return new ResponseEntity<>(CouponId, HttpStatus.CREATED);
    }@GetMapping("/{id}")
    public ResponseEntity<CouponResponse> getCouponById(@PathVariable("id") UUID CouponId){
        CouponResponse CouponResponse = couponService.getCouponById(CouponId);
        return new ResponseEntity<>(CouponResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CouponResponse>> getAllCategoris() {
        List<CouponResponse> CouponResponses = couponService.getAllCoupons();
        return ResponseEntity.ok(CouponResponses); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponResponse> editCoupon(@PathVariable("id") UUID CouponId , CouponRequest CouponRequest){
        couponService.editCoupon(CouponId, CouponRequest);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteCouponById(@PathVariable("id") UUID CouponId){
        couponService.deleteCouponById(CouponId);
    }

}
