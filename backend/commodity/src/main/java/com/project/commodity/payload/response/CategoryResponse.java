package com.project.commodity.payload.response;


import java.sql.Timestamp;
import java.util.UUID;

import com.project.commodity.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponse {
    private UUID id;
    private String CategoryName;
    private String Image;
    private String desciption;
    private Category parentCategory;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
    private Integer status;

}
