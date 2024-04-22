package com.thaihoangchuong.bannerservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.bannerservice.payload.request.InformationRequest;
import com.thaihoangchuong.bannerservice.payload.response.InformationResponse;

public interface InformationService {
    InformationResponse create(InformationRequest InformationRequest);
    InformationResponse getById( UUID id);
    List<InformationResponse> getAll();
    InformationResponse update(UUID id , InformationRequest InformationRequest);
    InformationResponse delete(UUID id);
}
