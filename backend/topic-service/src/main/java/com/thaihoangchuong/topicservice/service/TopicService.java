package com.thaihoangchuong.topicservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.topicservice.payload.request.TopicRequest;
import com.thaihoangchuong.topicservice.payload.response.TopicResponse;

public interface TopicService {

    TopicResponse create(TopicRequest TopicRequest);
    TopicResponse getById( UUID id);
    List<TopicResponse> getAll();
    TopicResponse update(UUID id , TopicRequest TopicRequest);
    TopicResponse delete(UUID id);
}
