package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.ProductGallary;
import com.project.commodity.exception.ProductGallaryServiceCustomException;
import com.project.commodity.payload.request.ProductGallaryRequest;
import com.project.commodity.payload.response.ProductGallaryResponse;
import com.project.commodity.repository.ProductGallaryRepository;
import com.project.commodity.service.ProductGallaryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductGallaryServiceImpl implements ProductGallaryService {

    private final ProductGallaryRepository productGallaryRepository;

    @Override
    public UUID addProductGallary(ProductGallaryRequest request) {
        ProductGallary productGallary = new ProductGallary();
        BeanUtils.copyProperties(request, productGallary);
        ProductGallary savedProductGallary = productGallaryRepository.save(productGallary);
        return savedProductGallary.getId();
    }

    @Override
    public List<ProductGallaryResponse> getAllProductGallarys() {
        return productGallaryRepository.findAll().stream()
                .map(productGallary -> {
                    ProductGallaryResponse response = new ProductGallaryResponse();
                    BeanUtils.copyProperties(productGallary, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductGallaryResponse getProductGallaryById(UUID productGallaryId) {
        ProductGallary productGallary = productGallaryRepository.findById(productGallaryId)
                .orElseThrow(() -> new ProductGallaryServiceCustomException("Product gallary with given ID not found", "product_gallary_not_found"));
        ProductGallaryResponse response = new ProductGallaryResponse();
        BeanUtils.copyProperties(productGallary, response);
        return response;
    }

    @Override
    public ProductGallaryResponse editProductGallary(UUID productGallaryId, ProductGallaryRequest request) {
        ProductGallary productGallary = productGallaryRepository.findById(productGallaryId)
                .orElseThrow(() -> new ProductGallaryServiceCustomException("Product gallary with given ID not found", "product_gallary_not_found"));
        BeanUtils.copyProperties(request, productGallary);
        ProductGallary savedProductGallary = productGallaryRepository.save(productGallary);
        ProductGallaryResponse response = new ProductGallaryResponse();
        BeanUtils.copyProperties(savedProductGallary, response);
        return response;
    }

    @Override
    public void deleteProductGallaryById(UUID productGallaryId) {
        log.info("Deleting product gallary with ID: {}", productGallaryId);
        productGallaryRepository.deleteById(productGallaryId);
    }
}

