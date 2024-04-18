package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.project.commodity.entity.Category;
import com.project.commodity.entity.Product;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductCategoryRequest {

    private Category CategoryId;

    private Product ProductId;
}
