package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

import com.project.commodity.entity.Product;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductGallaryRequest {


    private Product ProductId;

    private String image;
    private Timestamp CreatedAt;

    private Timestamp UpdatedAt;

    private UUID CreatedBy;

    private UUID UpdatedBy;
}
