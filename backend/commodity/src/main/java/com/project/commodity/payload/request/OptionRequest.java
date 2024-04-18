package com.project.commodity.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import com.project.commodity.entity.Category;
import com.project.commodity.entity.Product;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OptionRequest {
    private Product ProductId;
    private Category CategoryId;
    private String Name;
    private String desciption;
    private String Detail;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
