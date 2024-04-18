package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.ProductTag;
import com.project.commodity.exception.ProductTagServiceCustomException;
import com.project.commodity.payload.request.ProductTagRequest;
import com.project.commodity.payload.response.ProductTagResponse;
import com.project.commodity.repository.ProductTagRepository;
import com.project.commodity.service.ProductTagService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductTagServiceImpl implements ProductTagService {

    private final ProductTagRepository productTagRepository;

    @Override
    public UUID addProductTag(ProductTagRequest request) {
        ProductTag productTag = new ProductTag();
        BeanUtils.copyProperties(request, productTag);
        ProductTag savedProductTag = productTagRepository.save(productTag);
        return savedProductTag.getId();
    }

    @Override
    public List<ProductTagResponse> getAllProductTags() {
        return productTagRepository.findAll().stream()
                .map(productTag -> {
                    ProductTagResponse response = new ProductTagResponse();
                    BeanUtils.copyProperties(productTag, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductTagResponse getProductTagById(UUID productTagId) {
        ProductTag productTag = productTagRepository.findById(productTagId)
                .orElseThrow(() -> new ProductTagServiceCustomException("Product tag with given ID not found", "product_tag_not_found"));
        ProductTagResponse response = new ProductTagResponse();
        BeanUtils.copyProperties(productTag, response);
        return response;
    }

    @Override
    public ProductTagResponse editProductTag(UUID productTagId, ProductTagRequest request) {
        ProductTag productTag = productTagRepository.findById(productTagId)
                .orElseThrow(() -> new ProductTagServiceCustomException("Product tag with given ID not found", "product_tag_not_found"));
        BeanUtils.copyProperties(request, productTag);
        ProductTag savedProductTag = productTagRepository.save(productTag);
        ProductTagResponse response = new ProductTagResponse();
        BeanUtils.copyProperties(savedProductTag, response);
        return response;
    }

    @Override
    public void deleteProductTagById(UUID productTagId) {
        log.info("Deleting product tag with ID: {}", productTagId);
        productTagRepository.deleteById(productTagId);
    }
}
