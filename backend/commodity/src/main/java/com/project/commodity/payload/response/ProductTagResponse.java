package com.project.commodity.payload.response;

import java.util.UUID;

import com.project.commodity.entity.Product;
import com.project.commodity.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTagResponse {


    private UUID id;
    private Product ProductId;

    private Tag TagId;
}
