package com.thaihoangchuong.bannerservice.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class InformationRequest {
    
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
