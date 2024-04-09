package com.thaihoangchuong.Brand.payload.response;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {
    private Integer id;
    private String BrandName;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
