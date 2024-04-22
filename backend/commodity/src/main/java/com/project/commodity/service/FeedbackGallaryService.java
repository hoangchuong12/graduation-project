package com.project.commodity.service;



import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.FeedbackGallaryRequest;
import com.project.commodity.payload.response.FeedbackGallaryResponse;

public interface FeedbackGallaryService {

    FeedbackGallaryResponse create(FeedbackGallaryRequest feedbackGallaryRequest);

    FeedbackGallaryResponse getById(UUID id);

    List<FeedbackGallaryResponse> getAll();

    FeedbackGallaryResponse update(UUID id, FeedbackGallaryRequest feedbackGallaryRequest);

    FeedbackGallaryResponse delete(UUID id);

    List<FeedbackGallaryResponse> findByFeedbackId(UUID feedbackId);

    void deleteByFeedbackId(UUID feedbackId);
}
