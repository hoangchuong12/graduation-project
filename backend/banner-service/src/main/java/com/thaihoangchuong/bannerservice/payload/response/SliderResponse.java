package com.thaihoangchuong.bannerservice.payload.response;


import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SliderResponse {
    private UUID id;
    private String Name;
    private String Image;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
