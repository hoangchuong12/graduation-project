package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.Coupon;
import com.project.commodity.exception.CouponServiceCustomException;
import com.project.commodity.payload.request.CouponRequest;
import com.project.commodity.payload.response.CouponResponse;
import com.project.commodity.repository.CouponRepository;
import com.project.commodity.service.CouponService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public UUID addCoupon(CouponRequest request) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(request, coupon);
        Coupon savedCoupon = couponRepository.save(coupon);
        return savedCoupon.getId();
    }

    @Override
    public List<CouponResponse> getAllCoupons() {
        return couponRepository.findAll().stream()
                .map(coupon -> {
                    CouponResponse response = new CouponResponse();
                    BeanUtils.copyProperties(coupon, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CouponResponse getCouponById(UUID couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponServiceCustomException("Coupon with given ID not found", "coupon_not_found"));
        CouponResponse response = new CouponResponse();
        BeanUtils.copyProperties(coupon, response);
        return response;
    }

    @Override
    public CouponResponse editCoupon(UUID couponId, CouponRequest request) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponServiceCustomException("Coupon with given ID not found", "coupon_not_found"));
        BeanUtils.copyProperties(request, coupon);
        Coupon savedCoupon = couponRepository.save(coupon);
        CouponResponse response = new CouponResponse();
        BeanUtils.copyProperties(savedCoupon, response);
        return response;
    }

    @Override
    public void deleteCouponById(UUID couponId) {
        log.info("Deleting coupon with ID: {}", couponId);
        couponRepository.deleteById(couponId);
    }
}
