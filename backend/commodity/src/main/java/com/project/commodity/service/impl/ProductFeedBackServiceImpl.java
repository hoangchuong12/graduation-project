package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.ProductFeedBack;
import com.project.commodity.exception.ProductFeedBackServiceCustomException;
import com.project.commodity.payload.request.ProductFeedBackRequest;
import com.project.commodity.payload.response.ProductFeedBackResponse;
import com.project.commodity.repository.ProductFeedBackRepository;
import com.project.commodity.service.ProductFeedBackService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductFeedBackServiceImpl implements ProductFeedBackService {

    private final ProductFeedBackRepository productFeedBackRepository;

    @Override
    public UUID addProductFeedBack(ProductFeedBackRequest request) {
        ProductFeedBack productFeedBack = new ProductFeedBack();
        BeanUtils.copyProperties(request, productFeedBack);
        ProductFeedBack savedProductFeedBack = productFeedBackRepository.save(productFeedBack);
        return savedProductFeedBack.getId();
    }

    @Override
    public List<ProductFeedBackResponse> getAllProductFeedBacks() {
        return productFeedBackRepository.findAll().stream()
                .map(productFeedBack -> {
                    ProductFeedBackResponse response = new ProductFeedBackResponse();
                    BeanUtils.copyProperties(productFeedBack, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductFeedBackResponse getProductFeedBackById(UUID productFeedBackId) {
        ProductFeedBack productFeedBack = productFeedBackRepository.findById(productFeedBackId)
                .orElseThrow(() -> new ProductFeedBackServiceCustomException("Product feedback with given ID not found", "product_feedback_not_found"));
        ProductFeedBackResponse response = new ProductFeedBackResponse();
        BeanUtils.copyProperties(productFeedBack, response);
        return response;
    }

    @Override
    public ProductFeedBackResponse editProductFeedBack(UUID productFeedBackId, ProductFeedBackRequest request) {
        ProductFeedBack productFeedBack = productFeedBackRepository.findById(productFeedBackId)
                .orElseThrow(() -> new ProductFeedBackServiceCustomException("Product feedback with given ID not found", "product_feedback_not_found"));
        BeanUtils.copyProperties(request, productFeedBack);
        ProductFeedBack savedProductFeedBack = productFeedBackRepository.save(productFeedBack);
        ProductFeedBackResponse response = new ProductFeedBackResponse();
        BeanUtils.copyProperties(savedProductFeedBack, response);
        return response;
    }

    @Override
    public void deleteProductFeedBackById(UUID productFeedBackId) {
        log.info("Deleting product feedback with ID: {}", productFeedBackId);
        productFeedBackRepository.deleteById(productFeedBackId);
    }
}
