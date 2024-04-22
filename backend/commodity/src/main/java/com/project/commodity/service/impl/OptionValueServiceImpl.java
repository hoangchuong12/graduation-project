package com.project.commodity.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.commodity.entity.OptionValue;
import com.project.commodity.payload.request.OptionValueRequest;
import com.project.commodity.payload.response.OptionValueResponse;
import com.project.commodity.repository.OptionValueRepository;
import com.project.commodity.service.OptionValueService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OptionValueServiceImpl implements OptionValueService {

    private final OptionValueRepository optionValueRepository;

    public OptionValueServiceImpl(OptionValueRepository optionValueRepository) {
        this.optionValueRepository = optionValueRepository;
    }

    @Override
    public OptionValueResponse create(OptionValueRequest optionValueRequest) {
        OptionValue optionValue = new OptionValue();
        mapRequestToEntity(optionValueRequest, optionValue);
        optionValue.setCreatedAt(LocalDateTime.now());
        OptionValue savedOptionValue = optionValueRepository.save(optionValue);
        return mapOptionValueToResponse(savedOptionValue);
    }

    @Override
    public OptionValueResponse getById(UUID id) {
        OptionValue optionValue = optionValueRepository.findById(id).orElse(null);
        if (optionValue != null) {
            return mapOptionValueToResponse(optionValue);
        }
        return null;
    }

    @Override
    public List<OptionValueResponse> getAll() {
        List<OptionValue> optionValues = optionValueRepository.findAll();
        return optionValues.stream()
                .map(this::mapOptionValueToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OptionValueResponse update(UUID id, OptionValueRequest optionValueRequest) {
        OptionValue existingOptionValue = optionValueRepository.findById(id).orElse(null);
        if (existingOptionValue != null) {
            mapRequestToEntity(optionValueRequest, existingOptionValue);
            existingOptionValue.setUpdatedAt(LocalDateTime.now());
            OptionValue updatedOptionValue = optionValueRepository.save(existingOptionValue);
            return mapOptionValueToResponse(updatedOptionValue);
        }
        return null;
    }

    @Override
    public OptionValueResponse delete(UUID id) {
        OptionValue optionValue = optionValueRepository.findById(id).orElse(null);
        if (optionValue != null) {
            optionValueRepository.delete(optionValue);
            return mapOptionValueToResponse(optionValue);
        }
        return null;
    }

    @Override
    public List<OptionValueResponse> findByOptionId(UUID optionId) {
        List<OptionValue> optionValues = optionValueRepository.findByOptionId(optionId);
        return optionValues.stream()
                .map(this::mapOptionValueToResponse)
                .collect(Collectors.toList());
    }

    private OptionValueResponse mapOptionValueToResponse(OptionValue optionValue) {
        return OptionValueResponse.builder()
                .id(optionValue.getId())
                .optionId(optionValue.getOptionId())
                .value(optionValue.getValue())
                .createdAt(optionValue.getCreatedAt())
                .updatedAt(optionValue.getUpdatedAt())
                .createdBy(optionValue.getCreatedBy())
                .updatedBy(optionValue.getUpdatedBy())
                .build();
    }

    private void mapRequestToEntity(OptionValueRequest optionValueRequest, OptionValue optionValue) {
        BeanUtils.copyProperties(optionValueRequest, optionValue);
    }
}
