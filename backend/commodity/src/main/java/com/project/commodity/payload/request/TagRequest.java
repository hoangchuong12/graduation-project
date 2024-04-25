package com.project.commodity.payload.request;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TagRequest {

    private String name;

    private String icon;

    private UUID createdBy;

    private UUID updatedBy;
}
