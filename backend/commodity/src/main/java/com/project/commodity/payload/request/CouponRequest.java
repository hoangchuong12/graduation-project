package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;


import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CouponRequest {

    private UUID OrderId;
    private String CouponCode;
    private int DiscountAmount;
    private Timestamp ExpirationDate;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
    private Integer status;
}
