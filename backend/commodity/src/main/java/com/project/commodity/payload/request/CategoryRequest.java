package com.project.commodity.payload.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryRequest {

    private String name;

    private String image;

    private Long productQuantity;

    private String description;

    private UUID createdBy;

    private UUID updatedBy;

    private Integer status;
}
