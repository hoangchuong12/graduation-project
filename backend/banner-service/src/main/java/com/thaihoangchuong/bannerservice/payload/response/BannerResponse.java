package com.thaihoangchuong.bannerservice.payload.response;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BannerResponse {
    private UUID id;
    private String Name;
    
    @Lob
    private byte[] image;
    private String Description;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
