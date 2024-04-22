package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductFeedbackRequest;
import com.project.commodity.payload.response.ProductFeedbackResponse;

public interface ProductFeedbackService {

    ProductFeedbackResponse create(ProductFeedbackRequest productFeedbackRequest);

    ProductFeedbackResponse getById(UUID id);

    List<ProductFeedbackResponse> getAll();

    ProductFeedbackResponse update(UUID id, ProductFeedbackRequest productFeedbackRequest);

    ProductFeedbackResponse delete(UUID id);

    List<ProductFeedbackResponse> findByProductId(UUID productId);
}
