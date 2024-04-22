package com.project.commodity.service;



import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.OptionRequest;
import com.project.commodity.payload.response.OptionResponse;

public interface OptionService {

    OptionResponse create(OptionRequest optionRequest);

    OptionResponse getById(UUID id);

    List<OptionResponse> getAll();

    OptionResponse update(UUID id, OptionRequest optionRequest);

    OptionResponse delete(UUID id);
}
