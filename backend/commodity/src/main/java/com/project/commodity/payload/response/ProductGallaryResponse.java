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
public class ProductGallaryResponse {
    private UUID id;

    private Product ProductId;

    private String image;
    private Timestamp CreatedAt;

    private Timestamp UpdatedAt;

    private UUID CreatedBy;

    private UUID UpdatedBy;
}
