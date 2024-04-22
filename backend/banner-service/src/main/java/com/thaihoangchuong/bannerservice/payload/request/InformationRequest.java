package com.thaihoangchuong.bannerservice.payload.request;

import java.util.UUID;

import jakarta.persistence.Lob;
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
    @Lob
    private byte[] logo;
    private String Address;
    private String Email;
    private int Phone;
    private int BusinessNumber;
    private String License;
    private String Represent;
    private String RepresentPhone;
    private UUID UpdatedBy;
}
