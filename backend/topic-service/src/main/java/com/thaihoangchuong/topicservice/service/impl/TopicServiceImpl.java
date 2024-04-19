package com.thaihoangchuong.topicservice.service.impl;

import com.thaihoangchuong.topicservice.entity.Topic;
import com.thaihoangchuong.topicservice.exception.TopicServiceCustomException;
import com.thaihoangchuong.topicservice.payload.request.TopicRequest;
import com.thaihoangchuong.topicservice.payload.response.TopicResponse;
import com.thaihoangchuong.topicservice.repository.TopicRepository;
import com.thaihoangchuong.topicservice.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public UUID addTopic(TopicRequest topicRequest) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(topicRequest, topic);
        Topic savedTopic = topicRepository.save(topic);
        return savedTopic.getId();
    }

    @Override
    public List<TopicResponse> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TopicResponse getTopicById(UUID topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicServiceCustomException("Topic with given ID not found", "topic_not_found"));
        return convertToResponse(topic);
    }

    @Override
    public TopicResponse editTopic(UUID topicId, TopicRequest topicRequest) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicServiceCustomException("Topic with given ID not found", "topic_not_found"));
        BeanUtils.copyProperties(topicRequest, topic);
        Topic savedTopic = topicRepository.save(topic);
        return convertToResponse(savedTopic);
    }

    @Override
    public void deleteTopicById(UUID topicId) {
        topicRepository.deleteById(topicId);
    }

    private TopicResponse convertToResponse(Topic topic) {
        TopicResponse response = new TopicResponse();
        BeanUtils.copyProperties(topic, response);
        return response;
    }
}

