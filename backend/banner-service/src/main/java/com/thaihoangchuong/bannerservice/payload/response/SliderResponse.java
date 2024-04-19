package com.thaihoangchuong.bannerservice.payload.response;


import java.sql.Timestamp;
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
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
}
