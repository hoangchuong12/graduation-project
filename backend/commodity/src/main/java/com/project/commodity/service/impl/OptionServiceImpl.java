package com.project.commodity.service.impl;



import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.project.commodity.entity.Option;
import com.project.commodity.exception.OptionServiceCustomException;
import com.project.commodity.payload.request.OptionRequest;
import com.project.commodity.payload.response.OptionResponse;
import com.project.commodity.repository.OptionRepository;
import com.project.commodity.service.OptionService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Override
    public UUID addOption(OptionRequest request) {
        Option option = new Option();
        BeanUtils.copyProperties(request, option);
        Option savedOption = optionRepository.save(option);
        return savedOption.getId();
    }

    @Override
    public List<OptionResponse> getAllOptions() {
        return optionRepository.findAll().stream()
                .map(option -> {
                    OptionResponse response = new OptionResponse();
                    BeanUtils.copyProperties(option, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public OptionResponse getOptionById(UUID optionId) {
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionServiceCustomException("Option with given ID not found", "option_not_found"));
        OptionResponse response = new OptionResponse();
        BeanUtils.copyProperties(option, response);
        return response;
    }

    @Override
    public OptionResponse editOption(UUID optionId, OptionRequest request) {
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionServiceCustomException("Option with given ID not found", "option_not_found"));
        BeanUtils.copyProperties(request, option);
        Option savedOption = optionRepository.save(option);
        OptionResponse response = new OptionResponse();
        BeanUtils.copyProperties(savedOption, response);
        return response;
    }

    @Override
    public void deleteOptionById(UUID optionId) {
        log.info("Deleting option with ID: {}", optionId);
        optionRepository.deleteById(optionId);
    }
}
