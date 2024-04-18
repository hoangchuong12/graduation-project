package com.project.commodity.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.OptionValue;
import com.project.commodity.exception.OptionValueServiceCustomException;
import com.project.commodity.payload.request.OptionValueRequest;
import com.project.commodity.payload.response.OptionValueResponse;
import com.project.commodity.repository.OptionValueRepository;
import com.project.commodity.service.OptionValueService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class OptionValueServiceImpl implements OptionValueService {

    private final OptionValueRepository optionValueRepository;

    @Override
    public UUID addOptionValue(OptionValueRequest request) {
        OptionValue optionValue = new OptionValue();
        BeanUtils.copyProperties(request, optionValue);
        OptionValue savedOptionValue = optionValueRepository.save(optionValue);
        return savedOptionValue.getId();
    }

    @Override
    public List<OptionValueResponse> getAllOptionValues() {
        return optionValueRepository.findAll().stream()
                .map(optionValue -> {
                    OptionValueResponse response = new OptionValueResponse();
                    BeanUtils.copyProperties(optionValue, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public OptionValueResponse getOptionValueById(UUID optionValueId) {
        OptionValue optionValue = optionValueRepository.findById(optionValueId)
                .orElseThrow(() -> new OptionValueServiceCustomException("Option value with given ID not found", "option_value_not_found"));
        OptionValueResponse response = new OptionValueResponse();
        BeanUtils.copyProperties(optionValue, response);
        return response;
    }

    @Override
    public OptionValueResponse editOptionValue(UUID optionValueId, OptionValueRequest request) {
        OptionValue optionValue = optionValueRepository.findById(optionValueId)
                .orElseThrow(() -> new OptionValueServiceCustomException("Option value with given ID not found", "option_value_not_found"));
        BeanUtils.copyProperties(request, optionValue);
        OptionValue savedOptionValue = optionValueRepository.save(optionValue);
        OptionValueResponse response = new OptionValueResponse();
        BeanUtils.copyProperties(savedOptionValue, response);
        return response;
    }

    @Override
    public void deleteOptionValueById(UUID optionValueId) {
        log.info("Deleting option value with ID: {}", optionValueId);
        optionValueRepository.deleteById(optionValueId);
    }
}
