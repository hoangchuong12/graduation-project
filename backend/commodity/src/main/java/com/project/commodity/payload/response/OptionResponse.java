package com.project.commodity.payload.response;

import java.sql.Timestamp;
import java.util.UUID;

import com.project.commodity.entity.Category;
import com.project.commodity.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionResponse {

    private UUID id;
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
