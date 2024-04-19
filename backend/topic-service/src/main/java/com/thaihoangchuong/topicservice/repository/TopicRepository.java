package com.thaihoangchuong.topicservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.topicservice.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, UUID>{

}
