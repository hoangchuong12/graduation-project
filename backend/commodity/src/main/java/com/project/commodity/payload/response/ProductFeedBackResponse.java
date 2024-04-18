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
public class ProductFeedBackResponse {
    private UUID id;
    private UUID OrderItemId;
    private UUID UserID;
    private Product ProductId;
    private int Evaluate;
    private String Image;
    private String description;
    private String Detail;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
