package com.project.commodity.service;

import java.util.List;
import java.util.UUID;

import com.project.commodity.payload.request.OptionRequest;
import com.project.commodity.payload.response.OptionResponse;
public interface OptionService {
    public UUID addOption(OptionRequest OptionRequest);
    public List <OptionResponse> getAllOptions();
    public OptionResponse getOptionById (UUID OptionId);
    public OptionResponse editOption(UUID OptionId, OptionRequest OptionRequest);
    public void deleteOptionById(UUID OptionId);
}
