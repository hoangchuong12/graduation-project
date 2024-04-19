package com.thaihoangchuong.bannerservice.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BannerRequest {
    private String Name;
    private String Image;
    private String Description;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
