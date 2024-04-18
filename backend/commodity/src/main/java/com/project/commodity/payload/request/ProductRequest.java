package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import com.project.commodity.entity.Brand;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductRequest {
    private Brand BrandId;
    private String ProductName;
    private double Price;
    private double detail;
    private String Description;
    private Integer evaluate;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
    private Integer satatus;
}
