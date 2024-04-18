package com.project.commodity.payload.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.project.commodity.entity.Option;
import com.project.commodity.entity.Product;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductOptionRequest {

    private Product ProductId;

    private Option OptionId;
}
