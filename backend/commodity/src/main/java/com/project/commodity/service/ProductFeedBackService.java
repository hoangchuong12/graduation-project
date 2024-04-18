package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductFeedBackRequest;
import com.project.commodity.payload.response.ProductFeedBackResponse;

public interface ProductFeedBackService {
    public UUID addProductFeedBack(ProductFeedBackRequest ProductFeedBackRequest);
    public List <ProductFeedBackResponse> getAllProductFeedBacks();
    public ProductFeedBackResponse getProductFeedBackById (UUID ProductFeedBackId);
    public ProductFeedBackResponse editProductFeedBack(UUID ProductFeedBackId, ProductFeedBackRequest ProductFeedBackRequest);
    public void deleteProductFeedBackById(UUID ProductFeedBackId);
}
