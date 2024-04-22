package com.thaihoangchuong.bannerservice.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import jakarta.persistence.Lob;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BannerRequest {
    private String Name;
    @Lob
    private byte[] image;
    private String Description;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
