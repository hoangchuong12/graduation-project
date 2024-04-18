package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductSaleRequest;
import com.project.commodity.payload.response.ProductSaleResponse;

public interface ProductSaleService {
    public UUID addProductSale(ProductSaleRequest ProductSaleRequest);
    public List <ProductSaleResponse> getAllProductSales();
    public ProductSaleResponse getProductSaleById (UUID ProductSaleId);
    public ProductSaleResponse editProductSale(UUID ProductSaleId, ProductSaleRequest ProductSaleRequest);
    public void deleteProductSaleById(UUID ProductSaleId);

}
