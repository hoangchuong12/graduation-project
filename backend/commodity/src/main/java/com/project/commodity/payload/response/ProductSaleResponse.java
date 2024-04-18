package com.project.commodity.payload.response;


import java.sql.Timestamp;
import java.util.UUID;

import com.project.commodity.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaleResponse {
    private UUID id;
    private Product ProductId;
    private Double Quantity;
    private double PriceSale;
    private String Detail;
    private String Desciption;
    private Timestamp DateBegin;
    private Timestamp DateEnd;
    private Timestamp CratedAt;
    private Timestamp UpdatedAt;
}
