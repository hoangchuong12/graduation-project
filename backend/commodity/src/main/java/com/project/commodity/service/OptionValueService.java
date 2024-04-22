package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.OptionValueRequest;
import com.project.commodity.payload.response.OptionValueResponse;

public interface OptionValueService {

    OptionValueResponse create(OptionValueRequest optionValueRequest);

    OptionValueResponse getById(UUID id);

    List<OptionValueResponse> getAll();

    OptionValueResponse update(UUID id, OptionValueRequest optionValueRequest);

    OptionValueResponse delete(UUID id);

    List<OptionValueResponse> findByOptionId(UUID optionId);
}
