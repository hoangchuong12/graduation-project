package com.project.commodity.service;
import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.TagRequest;
import com.project.commodity.payload.response.TagResponse;

public interface TagService {

    TagResponse create(TagRequest tagRequest);

    TagResponse getById(UUID id);

    List<TagResponse> getAll();

    TagResponse update(UUID id, TagRequest tagRequest);

    TagResponse delete(UUID id);
}
