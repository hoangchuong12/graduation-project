package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import com.project.commodity.entity.Product;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductSaleRequest {
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
