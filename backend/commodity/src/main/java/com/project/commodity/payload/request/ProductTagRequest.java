package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import com.project.commodity.entity.Product;
import com.project.commodity.entity.Tag;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductTagRequest {


    private Product ProductId;

    private Tag TagId;
}
