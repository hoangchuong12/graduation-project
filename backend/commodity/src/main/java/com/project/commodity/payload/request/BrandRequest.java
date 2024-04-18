package com.project.commodity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BrandRequest {
  


    private String BrandName;

    private String Image;
 
    private String desciption;

    private String Title;

    private String Address;
  
    private Timestamp CreatedAt;

    private Timestamp UpdatedAt;

    private UUID CreatedBy;
 
    private UUID UpdatedBy;

    private Integer status;

}
