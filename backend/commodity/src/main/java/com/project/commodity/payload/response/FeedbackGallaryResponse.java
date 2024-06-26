package com.project.commodity.payload.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeedbackGallaryResponse {

    private UUID id;

    private UUID feedbackId;

    private String image;
}
