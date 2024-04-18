package com.project.commodity.payload.response;

import java.util.UUID;


import com.project.commodity.entity.Option;
import com.project.commodity.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOptionResponse {
    private UUID id;

    private Product ProductId;

    private Option OptionId;
}
