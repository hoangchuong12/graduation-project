package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.ProductRequest;
import com.project.commodity.payload.response.ProductResponse;

public interface ProductService {

    public UUID addProduct(ProductRequest ProductRequest);
    public List <ProductResponse> getAllProducts();
    public ProductResponse getProductById (UUID ProductId);
    public ProductResponse editProduct(UUID ProductId, ProductRequest ProductRequest);
    public void deleteProductById(UUID ProductId);

}
