package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.ProductSale;
import com.project.commodity.exception.ProductSaleServiceCustomException;
import com.project.commodity.payload.request.ProductSaleRequest;
import com.project.commodity.payload.response.ProductSaleResponse;
import com.project.commodity.repository.ProductSaleRepository;
import com.project.commodity.service.ProductSaleService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductSaleServiceImpl implements ProductSaleService {

    private final ProductSaleRepository productSaleRepository;

    @Override
    public UUID addProductSale(ProductSaleRequest request) {
        ProductSale productSale = new ProductSale();
        BeanUtils.copyProperties(request, productSale);
        ProductSale savedProductSale = productSaleRepository.save(productSale);
        return savedProductSale.getId();
    }

    @Override
    public List<ProductSaleResponse> getAllProductSales() {
        return productSaleRepository.findAll().stream()
                .map(productSale -> {
                    ProductSaleResponse response = new ProductSaleResponse();
                    BeanUtils.copyProperties(productSale, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductSaleResponse getProductSaleById(UUID productSaleId) {
        ProductSale productSale = productSaleRepository.findById(productSaleId)
                .orElseThrow(() -> new ProductSaleServiceCustomException("Product sale with given ID not found", "product_sale_not_found"));
        ProductSaleResponse response = new ProductSaleResponse();
        BeanUtils.copyProperties(productSale, response);
        return response;
    }

    @Override
    public ProductSaleResponse editProductSale(UUID productSaleId, ProductSaleRequest request) {
        ProductSale productSale = productSaleRepository.findById(productSaleId)
                .orElseThrow(() -> new ProductSaleServiceCustomException("Product sale with given ID not found", "product_sale_not_found"));
        BeanUtils.copyProperties(request, productSale);
        ProductSale savedProductSale = productSaleRepository.save(productSale);
        ProductSaleResponse response = new ProductSaleResponse();
        BeanUtils.copyProperties(savedProductSale, response);
        return response;
    }

    @Override
    public void deleteProductSaleById(UUID productSaleId) {
        log.info("Deleting product sale with ID: {}", productSaleId);
        productSaleRepository.deleteById(productSaleId);
    }
}
