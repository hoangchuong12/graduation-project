package com.thaihoangchuong.topicservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thaihoangchuong.topicservice.payload.request.TopicRequest;
import com.thaihoangchuong.topicservice.payload.response.TopicResponse;
import com.thaihoangchuong.topicservice.service.TopicService;

@RestController
@RequestMapping("topic-services/api/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/create")
    public ResponseEntity<TopicResponse> createTopic(@RequestBody TopicRequest topicRequest) {
        TopicResponse createdTopic = topicService.create(topicRequest);
        return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<TopicResponse> getTopicById(@PathVariable UUID id) {
        TopicResponse topic = topicService.getById(id);
        if (topic != null) {
            return ResponseEntity.ok(topic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TopicResponse>> getAllTopics() {
        List<TopicResponse> topics = topicService.getAll();
        return ResponseEntity.ok(topics);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TopicResponse> updateTopic(@PathVariable UUID id, @RequestBody TopicRequest topicRequest) {
        TopicResponse updatedTopic = topicService.update(id, topicRequest);
        if (updatedTopic != null) {
            return ResponseEntity.ok(updatedTopic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TopicResponse> deleteTopic(@PathVariable UUID id) {
        TopicResponse deletedTopic = topicService.delete(id);
        if (deletedTopic != null) {
            return ResponseEntity.ok(deletedTopic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
