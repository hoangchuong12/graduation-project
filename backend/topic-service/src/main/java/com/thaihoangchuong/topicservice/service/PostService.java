package com.thaihoangchuong.topicservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.topicservice.payload.request.PostRequest;
import com.thaihoangchuong.topicservice.payload.response.PostResponse;

public interface PostService {
    PostResponse create(PostRequest PostRequest);
    PostResponse getById( UUID id);
    List<PostResponse> getAll();
    PostResponse update(UUID id , PostRequest PostRequest);
    PostResponse delete(UUID id);
}
