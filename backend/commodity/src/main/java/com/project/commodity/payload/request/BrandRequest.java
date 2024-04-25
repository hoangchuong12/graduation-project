package com.project.commodity.payload.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BrandRequest {

    private String name;

    private String description;

    private String logo;

    private UUID createdBy;

    private Integer status;
}
