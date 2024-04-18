package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.ProductOption;
import com.project.commodity.exception.ProductOptionServiceCustomException;
import com.project.commodity.payload.request.ProductOptionRequest;
import com.project.commodity.payload.response.ProductOptionResponse;
import com.project.commodity.repository.ProductOptionRepository;
import com.project.commodity.service.ProductOptionService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductOptionServiceImpl implements ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Override
    public UUID addProductOption(ProductOptionRequest request) {
        ProductOption productOption = new ProductOption();
        BeanUtils.copyProperties(request, productOption);
        ProductOption savedProductOption = productOptionRepository.save(productOption);
        return savedProductOption.getId();
    }

    @Override
    public List<ProductOptionResponse> getAllProductOptions() {
        return productOptionRepository.findAll().stream()
                .map(productOption -> {
                    ProductOptionResponse response = new ProductOptionResponse();
                    BeanUtils.copyProperties(productOption, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductOptionResponse getProductOptionById(UUID productOptionId) {
        ProductOption productOption = productOptionRepository.findById(productOptionId)
                .orElseThrow(() -> new ProductOptionServiceCustomException("Product option with given ID not found", "product_option_not_found"));
        ProductOptionResponse response = new ProductOptionResponse();
        BeanUtils.copyProperties(productOption, response);
        return response;
    }

    @Override
    public ProductOptionResponse editProductOption(UUID productOptionId, ProductOptionRequest request) {
        ProductOption productOption = productOptionRepository.findById(productOptionId)
                .orElseThrow(() -> new ProductOptionServiceCustomException("Product option with given ID not found", "product_option_not_found"));
        BeanUtils.copyProperties(request, productOption);
        ProductOption savedProductOption = productOptionRepository.save(productOption);
        ProductOptionResponse response = new ProductOptionResponse();
        BeanUtils.copyProperties(savedProductOption, response);
        return response;
    }

    @Override
    public void deleteProductOptionById(UUID productOptionId) {
        log.info("Deleting product option with ID: {}", productOptionId);
        productOptionRepository.deleteById(productOptionId);
    }
}
