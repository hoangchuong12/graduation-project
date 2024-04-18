package com.project.commodity.payload.response;

import java.sql.Timestamp;
import java.util.UUID;

import com.project.commodity.entity.Brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private UUID id;
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
