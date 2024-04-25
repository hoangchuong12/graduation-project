package com.thaihoangchuong.topicservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.thaihoangchuong.topicservice.entity.Post;
import com.thaihoangchuong.topicservice.payload.request.PostRequest;
import com.thaihoangchuong.topicservice.payload.response.PostResponse;
import com.thaihoangchuong.topicservice.repository.PostRepository;
import com.thaihoangchuong.topicservice.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostResponse create(PostRequest postRequest) {
        Post post = new Post();
        mapRequestToEntity(postRequest, post);
        post.setCreatedAt(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        return mapPostToPostResponse(savedPost);
    }

    @Override
    public PostResponse getById(UUID id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            return mapPostToPostResponse(post);
        }
        return null;
    }

    @Override
    public List<PostResponse> getAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::mapPostToPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse update(UUID id, PostRequest postRequest) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            mapRequestToEntity(postRequest, existingPost);
            Post updatedPost = postRepository.save(existingPost);
            return mapPostToPostResponse(updatedPost);
        }
        return null;
    }

    @Override
    public PostResponse delete(UUID id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            postRepository.delete(post);
            return mapPostToPostResponse(post);
        }
        return null;
    }

    private PostResponse mapPostToPostResponse(Post post) {
        if (post != null) {
            return PostResponse.builder()
                    .id(post.getId())
                    .TopicId(post.getTopicId())
                    .Image(post.getImage())
                    .NumLike(post.getNumLike())
                    .Description(post.getDescription())
                    .CreatedAt(post.getCreatedAt())
                    .UpdatedAt(post.getUpdatedAt())
                    .CreatedBy(post.getCreatedBy())
                    .UpdatedBy(post.getUpdatedBy())
                    .build();
        }
        return null;
    }

    private void mapRequestToEntity(PostRequest postRequest, Post post) {
        BeanUtils.copyProperties(postRequest, post);
    }
}
