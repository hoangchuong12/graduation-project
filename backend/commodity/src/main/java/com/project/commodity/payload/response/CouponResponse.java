package com.project.commodity.payload.response;

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
public class CouponResponse {


    private UUID id;
    private UUID OrderId;
    private String CouponCode;
    private int DiscountAmount;
    private Timestamp ExpirationDate;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
