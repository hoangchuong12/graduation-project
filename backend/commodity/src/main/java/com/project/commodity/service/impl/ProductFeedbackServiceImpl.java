package com.project.commodity.service.impl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.commodity.entity.ProductFeedback;
import com.project.commodity.payload.request.ProductFeedbackRequest;
import com.project.commodity.payload.response.FeedbackGallaryResponse;
import com.project.commodity.payload.response.ProductFeedbackResponse;
import com.project.commodity.repository.ProductFeedbackRepository;
import com.project.commodity.service.FeedbackGallaryService;
import com.project.commodity.service.ProductFeedbackService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductFeedbackServiceImpl implements ProductFeedbackService {

    private final ProductFeedbackRepository productFeedbackRepository;
    private final FeedbackGallaryService feedbackGallaryService; // Injecting FeedbackGallaryService

    public ProductFeedbackServiceImpl(ProductFeedbackRepository productFeedbackRepository,
            FeedbackGallaryService feedbackGallaryService) {
        this.productFeedbackRepository = productFeedbackRepository;
        this.feedbackGallaryService = feedbackGallaryService; // Initializing FeedbackGallaryService
    }

@Override
public ProductFeedbackResponse create(ProductFeedbackRequest productFeedbackRequest) {
    ProductFeedback productFeedback = new ProductFeedback();
    mapRequestToEntity(productFeedbackRequest, productFeedback);
    productFeedback.setCreatedAt(LocalDateTime.now());
    ProductFeedback savedProductFeedback = productFeedbackRepository.save(productFeedback);
    List<FeedbackGallaryResponse> galleries = new ArrayList<>();
    return mapProductFeedbackToResponse(savedProductFeedback, galleries);
}


    @Override
    public ProductFeedbackResponse getById(UUID id) {
        ProductFeedback productFeedback = productFeedbackRepository.findById(id).orElse(null);
        if (productFeedback != null) {
            List<FeedbackGallaryResponse> galleries = feedbackGallaryService.findByFeedbackId(id);
            return mapProductFeedbackToResponse(productFeedback, galleries);
        }
        return null;
    }

    @Override
    public List<ProductFeedbackResponse> getAll() {
        List<ProductFeedback> productFeedbacks = productFeedbackRepository.findAll();
        return productFeedbacks.stream()
                .map(pf -> mapProductFeedbackToResponse(pf, new ArrayList<>()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductFeedbackResponse> findByProductId(UUID productId) {
        List<ProductFeedback> productFeedbacks = productFeedbackRepository.findByProductId(productId);
        return productFeedbacks.stream()
                .map(pf -> mapProductFeedbackToResponse(pf, new ArrayList<>()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductFeedbackResponse update(UUID id, ProductFeedbackRequest productFeedbackRequest) {
        ProductFeedback existingProductFeedback = productFeedbackRepository.findById(id).orElse(null);
        if (existingProductFeedback != null) {
            mapRequestToEntity(productFeedbackRequest, existingProductFeedback);
            existingProductFeedback.setUpdatedAt(LocalDateTime.now());
            ProductFeedback updatedProductFeedback = productFeedbackRepository.save(existingProductFeedback);
            List<FeedbackGallaryResponse> galleries = feedbackGallaryService.findByFeedbackId(id);
            return mapProductFeedbackToResponse(updatedProductFeedback, galleries);
        }
        return null;
    }

    @Override
    public ProductFeedbackResponse delete(UUID id) {
        ProductFeedback productFeedback = productFeedbackRepository.findById(id).orElse(null);
        if (productFeedback != null) {
            feedbackGallaryService.deleteByFeedbackId(productFeedback.getId());
            productFeedbackRepository.delete(productFeedback);
            return mapProductFeedbackToResponse(productFeedback, new ArrayList<>());
        }
        return null;
    }

    // Helper method to map entity to response object
    private ProductFeedbackResponse mapProductFeedbackToResponse(ProductFeedback productFeedback,
            List<FeedbackGallaryResponse> galleries) {
        return ProductFeedbackResponse.builder()
                .id(productFeedback.getId())
                .orderItemId(productFeedback.getOrderItemId())
                .productId(productFeedback.getProductId())
                .evaluate(productFeedback.getEvaluate())
                .description(productFeedback.getDescription())
                .detail(productFeedback.getDetail())
                .createdAt(productFeedback.getCreatedAt())
                .updatedAt(productFeedback.getUpdatedAt())
                .createdBy(productFeedback.getCreatedBy())
                .updatedBy(productFeedback.getUpdatedBy())
                .galleries(galleries)
                .build();
    }

    // Helper method to map request to entity object
    private void mapRequestToEntity(ProductFeedbackRequest productFeedbackRequest, ProductFeedback productFeedback) {
        BeanUtils.copyProperties(productFeedbackRequest, productFeedback);
    }
}
