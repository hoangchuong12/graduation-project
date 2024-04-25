package com.thaihoangchuong.topicservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.thaihoangchuong.topicservice.entity.Topic;
import com.thaihoangchuong.topicservice.payload.request.TopicRequest;
import com.thaihoangchuong.topicservice.payload.response.TopicResponse;
import com.thaihoangchuong.topicservice.repository.TopicRepository;
import com.thaihoangchuong.topicservice.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public TopicResponse create(TopicRequest topicRequest) {
        Topic topic = new Topic();
        mapRequestToEntity(topicRequest, topic);
        topic.setCreatedAt(LocalDateTime.now());
        Topic savedTopic = topicRepository.save(topic);
        return mapTopicToTopicResponse(savedTopic);
    }

    @Override
    public TopicResponse getById(UUID id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic != null) {
            return mapTopicToTopicResponse(topic);
        }
        return null;
    }

    @Override
    public List<TopicResponse> getAll() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream()
                .map(this::mapTopicToTopicResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TopicResponse update(UUID id, TopicRequest topicRequest) {
        Topic existingTopic = topicRepository.findById(id).orElse(null);
        if (existingTopic != null) {
            mapRequestToEntity(topicRequest, existingTopic);
            Topic updatedTopic = topicRepository.save(existingTopic);
            return mapTopicToTopicResponse(updatedTopic);
        }
        return null;
    }

    @Override
    public TopicResponse delete(UUID id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic != null) {
            topicRepository.delete(topic);
            return mapTopicToTopicResponse(topic);
        }
        return null;
    }

    private TopicResponse mapTopicToTopicResponse(Topic topic) {
        if (topic != null) {
            return TopicResponse.builder()
                    .id(topic.getId())
                    .Name(topic.getName())
                    .Image(topic.getImage())
                    .Description(topic.getDescription())
                    .CreatedAt(topic.getCreatedAt())
                    .UpdatedAt(topic.getUpdatedAt())
                    .CreatedBy(topic.getCreatedBy())
                    .UpdatedBy(topic.getUpdatedBy())
                    .build();
        }
        return null;
    }
    

    private void mapRequestToEntity(TopicRequest topicRequest, Topic topic) {
        BeanUtils.copyProperties(topicRequest, topic);
    }
}
