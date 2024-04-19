package com.thaihoangchuong.bannerservice.payload.request;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class SliderRequest {

    private String Name;
    private String Image;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
}
