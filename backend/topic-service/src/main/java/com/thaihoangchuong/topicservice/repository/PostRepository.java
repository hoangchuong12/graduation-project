package com.thaihoangchuong.topicservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thaihoangchuong.topicservice.entity.Post;

public interface PostRepository extends JpaRepository<Post,UUID>{

}
