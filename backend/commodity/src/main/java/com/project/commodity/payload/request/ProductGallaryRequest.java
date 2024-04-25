package com.project.commodity.payload.request;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductGallaryRequest {

    private UUID productId;

    private String image;

    private UUID createdBy;

    private UUID updatedBy;
}
