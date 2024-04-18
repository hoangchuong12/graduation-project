package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.Tag;
import com.project.commodity.exception.TagServiceCustomException;
import com.project.commodity.payload.request.TagRequest;
import com.project.commodity.payload.response.TagResponse;
import com.project.commodity.repository.TagRepository;
import com.project.commodity.service.TagService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public UUID addTag(TagRequest request) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(request, tag);
        Tag savedTag = tagRepository.save(tag);
        return savedTag.getId();
    }

    @Override
    public List<TagResponse> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tag -> {
                    TagResponse response = new TagResponse();
                    BeanUtils.copyProperties(tag, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TagResponse getTagById(UUID tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new TagServiceCustomException("Tag with given ID not found", "tag_not_found"));
        TagResponse response = new TagResponse();
        BeanUtils.copyProperties(tag, response);
        return response;
    }

    @Override
    public TagResponse editTag(UUID tagId, TagRequest request) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new TagServiceCustomException("Tag with given ID not found", "tag_not_found"));
        BeanUtils.copyProperties(request, tag);
        Tag savedTag = tagRepository.save(tag);
        TagResponse response = new TagResponse();
        BeanUtils.copyProperties(savedTag, response);
        return response;
    }

    @Override
    public void deleteTagById(UUID tagId) {
        log.info("Deleting tag with ID: {}", tagId);
        tagRepository.deleteById(tagId);
    }
}
