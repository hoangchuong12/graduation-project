package com.project.commodity.controller;

import com.project.commodity.payload.request.TagRequest;
import com.project.commodity.payload.response.TagResponse;
import com.project.commodity.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/PRODUCTS-SERVICE/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<UUID> addTag( @RequestBody TagRequest request) {
        UUID tagId = tagService.addTag(request);
        return new ResponseEntity<>(tagId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        List<TagResponse> tags = tagService.getAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponse> getTagById(@PathVariable("id") UUID tagId) {
        TagResponse tag = tagService.getTagById(tagId);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagResponse> editTag(@PathVariable("id") UUID tagId, @RequestBody TagRequest request) {
        TagResponse updatedTag = tagService.editTag(tagId, request);
        return new ResponseEntity<>(updatedTag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable("id") UUID tagId) {
        tagService.deleteTagById(tagId);
        return ResponseEntity.noContent().build();
    }
}
