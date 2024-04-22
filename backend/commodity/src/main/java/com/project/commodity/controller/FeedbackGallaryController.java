package com.project.commodity.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.commodity.payload.request.FeedbackGallaryRequest;
import com.project.commodity.payload.response.FeedbackGallaryResponse;
import com.project.commodity.service.FeedbackGallaryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product-services/api/feedback-galleries")
public class FeedbackGallaryController {

    private final FeedbackGallaryService feedbackGallaryService;

    public FeedbackGallaryController(FeedbackGallaryService feedbackGallaryService) {
        this.feedbackGallaryService = feedbackGallaryService;
    }

    @PostMapping("/create")
    public ResponseEntity<FeedbackGallaryResponse> createFeedbackGallary(@RequestBody FeedbackGallaryRequest feedbackGallaryRequest) {
        FeedbackGallaryResponse createdFeedbackGallary = feedbackGallaryService.create(feedbackGallaryRequest);
        return new ResponseEntity<>(createdFeedbackGallary, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<FeedbackGallaryResponse> getFeedbackGallaryById(@PathVariable UUID id) {
        FeedbackGallaryResponse feedbackGallary = feedbackGallaryService.getById(id);
        if (feedbackGallary != null) {
            return ResponseEntity.ok(feedbackGallary);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<FeedbackGallaryResponse>> getAllFeedbackGalleries() {
        List<FeedbackGallaryResponse> feedbackGalleries = feedbackGallaryService.getAll();
        return ResponseEntity.ok(feedbackGalleries);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FeedbackGallaryResponse> updateFeedbackGallary(@RequestBody FeedbackGallaryRequest feedbackGallaryRequest, @PathVariable UUID id) {
        FeedbackGallaryResponse updatedFeedbackGallary = feedbackGallaryService.update(id, feedbackGallaryRequest);
        if (updatedFeedbackGallary != null) {
            return ResponseEntity.ok(updatedFeedbackGallary);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FeedbackGallaryResponse> deleteFeedbackGallary(@PathVariable UUID id) {
        FeedbackGallaryResponse deletedFeedbackGallary = feedbackGallaryService.delete(id);
        if (deletedFeedbackGallary != null) {
            return ResponseEntity.ok(deletedFeedbackGallary);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-feedback-id/{feedbackId}")
    public ResponseEntity<List<FeedbackGallaryResponse>> getFeedbackGalleriesByFeedbackId(@PathVariable UUID feedbackId) {
        List<FeedbackGallaryResponse> feedbackGalleries = feedbackGallaryService.findByFeedbackId(feedbackId);
        return ResponseEntity.ok(feedbackGalleries);
    }
}
