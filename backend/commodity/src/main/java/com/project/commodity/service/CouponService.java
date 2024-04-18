package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.CouponRequest;
import com.project.commodity.payload.response.CouponResponse;

public interface CouponService {
    public UUID addCoupon(CouponRequest CouponRequest);
    public List <CouponResponse> getAllCoupons();
    public CouponResponse getCouponById (UUID CouponId);
    public CouponResponse editCoupon(UUID CouponId, CouponRequest CouponRequest);
    public void deleteCouponById(UUID CouponId);
}
