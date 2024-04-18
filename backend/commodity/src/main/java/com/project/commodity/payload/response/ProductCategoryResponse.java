package com.project.commodity.payload.response;


import java.util.UUID;

import com.project.commodity.entity.Category;
import com.project.commodity.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryResponse {
    private UUID id;

    private Category CategoryId;

    private Product ProductId;
}
