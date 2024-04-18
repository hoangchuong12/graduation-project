package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.OptionValueRequest;
import com.project.commodity.payload.response.OptionValueResponse;

public interface OptionValueService {
    public UUID addOptionValue(OptionValueRequest OptionValueRequest);
    public List <OptionValueResponse> getAllOptionValues();
    public OptionValueResponse getOptionValueById (UUID OptionValueId);
    public OptionValueResponse editOptionValue(UUID OptionValueId, OptionValueRequest OptionValueRequest);
    public void deleteOptionValueById(UUID OptionValueId);
}
