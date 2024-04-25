package com.project.commodity.payload.request;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeedbackGallaryRequest {

    private UUID feedbackId;

    private String image;
}
