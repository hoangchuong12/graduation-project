package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.Product;
import com.project.commodity.exception.ProductServiceCustomExcePtion;
import com.project.commodity.payload.request.ProductRequest;
import com.project.commodity.payload.response.ProductResponse;
import com.project.commodity.repository.ProductRepository;
import com.project.commodity.service.ProductService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public UUID addProduct(ProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> {
                    ProductResponse response = new ProductResponse();
                    BeanUtils.copyProperties(product, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomExcePtion("Product with given ID not found", "product_not_found"));
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(product, response);
        return response;
    }

    @Override
    public ProductResponse editProduct(UUID productId, ProductRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomExcePtion("Product with given ID not found", "product_not_found"));
        BeanUtils.copyProperties(request, product);
        Product savedProduct = productRepository.save(product);
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(savedProduct, response);
        return response;
    }

    @Override
    public void deleteProductById(UUID productId) {
        log.info("Deleting product with ID: {}", productId);
        productRepository.deleteById(productId);
    }
}
