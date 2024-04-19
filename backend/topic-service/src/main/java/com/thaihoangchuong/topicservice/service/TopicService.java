package com.thaihoangchuong.topicservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.topicservice.payload.request.TopicRequest;
import com.thaihoangchuong.topicservice.payload.response.TopicResponse;

public interface TopicService {

    public UUID addTopic(TopicRequest TopicRequest);
    public List <TopicResponse> getAllTopics();
    public TopicResponse getTopicById (UUID TopicId);
    public TopicResponse editTopic(UUID TopicId, TopicRequest TopicRequest);
    public void deleteTopicById(UUID TopicId);
}
