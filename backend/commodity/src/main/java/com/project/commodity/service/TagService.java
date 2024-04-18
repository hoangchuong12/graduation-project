package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.TagRequest;
import com.project.commodity.payload.response.TagResponse;

public interface TagService {
    public UUID addTag(TagRequest TagRequest);
    public List <TagResponse> getAllTags();
    public TagResponse getTagById (UUID TagId);
    public TagResponse editTag(UUID TagId, TagRequest TagRequest);
    public void deleteTagById(UUID TagId);
}
