package com.thaihoangchuong.topicservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thaihoangchuong.topicservice.payload.request.PostRequest;
import com.thaihoangchuong.topicservice.payload.response.PostResponse;
import com.thaihoangchuong.topicservice.service.PostService;

@RestController
@RequestMapping("topic-services/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
        PostResponse createdPost = postService.create(postRequest);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable UUID id) {
        PostResponse post = postService.getById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> posts = postService.getAll();
        return ResponseEntity.ok(posts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable UUID id, @RequestBody PostRequest postRequest) {
        PostResponse updatedPost = postService.update(id, postRequest);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PostResponse> deletePost(@PathVariable UUID id) {
        PostResponse deletedPost = postService.delete(id);
        if (deletedPost != null) {
            return ResponseEntity.ok(deletedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
