package com.thaihoangchuong.topicservice.controller;


import com.thaihoangchuong.topicservice.payload.request.TopicRequest;
import com.thaihoangchuong.topicservice.payload.response.TopicResponse;
import com.thaihoangchuong.topicservice.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<UUID> addTopic(@RequestBody TopicRequest topicRequest) {
        UUID topicId = topicService.addTopic(topicRequest);
        return new ResponseEntity<>(topicId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getAllTopics() {
        List<TopicResponse> topics = topicService.getAllTopics();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> getTopicById(@PathVariable("id") UUID topicId) {
        TopicResponse topic = topicService.getTopicById(topicId);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponse> editTopic(@PathVariable("id") UUID topicId, @RequestBody TopicRequest topicRequest) {
        TopicResponse editedTopic = topicService.editTopic(topicId, topicRequest);
        return new ResponseEntity<>(editedTopic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopicById(@PathVariable("id") UUID topicId) {
        topicService.deleteTopicById(topicId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
