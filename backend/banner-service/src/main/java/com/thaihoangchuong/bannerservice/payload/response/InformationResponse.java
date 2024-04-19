package com.thaihoangchuong.bannerservice.payload.response;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationResponse {
    private UUID id;
    private String Name;
    private String Logo;
    private String Address;
    private String Email;
    private int Phone;
    private int BusinessNumber;
    private String License;
    private String Represent;
    private String RepresentPhone;
}
