package com.project.commodity.payload.request;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductOptionRequest {

    private UUID productId;

    private UUID optionId;
}
