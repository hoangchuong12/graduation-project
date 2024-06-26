package com.project.commodity.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.commodity.entity.Options;
import com.project.commodity.entity.ProductOption;
import com.project.commodity.payload.request.OptionRequest;
import com.project.commodity.payload.response.OptionResponse;
import com.project.commodity.repository.OptionRepository;
import com.project.commodity.repository.ProductOptionRepository;
import com.project.commodity.service.OptionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;
    private final ProductOptionRepository productOptionRepository;

    public OptionServiceImpl(OptionRepository optionRepository, ProductOptionRepository productOptionRepository) {
        this.optionRepository = optionRepository;
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public OptionResponse create(OptionRequest optionRequest) {
        Options option = new Options();
        mapRequestToEntity(optionRequest, option);
        option.setCreatedAt(LocalDateTime.now());
        Options savedOption = optionRepository.save(option);

        // Create ProductOption entity
        ProductOption productOption = new ProductOption();
        productOption.setProductId(optionRequest.getProductId());
        productOption.setOptionId(savedOption.getId());
        productOptionRepository.save(productOption);

        return mapOptionToResponse(savedOption);
    }

    @Override
    public OptionResponse getById(UUID id) {
        Options option = optionRepository.findById(id).orElse(null);
        if (option != null) {
            return mapOptionToResponse(option);
        }
        return null;
    }

    @Override
    public List<OptionResponse> getAll() {
        List<Options> options = optionRepository.findAll();
        return options.stream()
                .map(this::mapOptionToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OptionResponse update(UUID id, OptionRequest optionRequest) {
        Options existingOption = optionRepository.findById(id).orElse(null);
        if (existingOption != null) {
            mapRequestToEntity(optionRequest, existingOption);
            existingOption.setUpdatedAt(LocalDateTime.now());
            Options updatedOption = optionRepository.save(existingOption);
            return mapOptionToResponse(updatedOption);
        }
        return null;
    }

    @Override
    public OptionResponse delete(UUID id) {
        Options option = optionRepository.findById(id).orElse(null);
        if (option != null) {
            optionRepository.delete(option);
            return mapOptionToResponse(option);
        }
        return null;
    }

    private OptionResponse mapOptionToResponse(Options option) {
        return OptionResponse.builder()
                .id(option.getId())
                .name(option.getName())
                .description(option.getDescription())
                .detail(option.getDetail())
                .createdAt(option.getCreatedAt())
                .updatedAt(option.getUpdatedAt())
                .createdBy(option.getCreatedBy())
                .updatedBy(option.getUpdatedBy())
                .build();
    }

    private void mapRequestToEntity(OptionRequest optionRequest, Options option) {
        BeanUtils.copyProperties(optionRequest, option);
    }
}
