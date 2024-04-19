package com.thaihoangchuong.bannerservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.bannerservice.payload.request.InformationRequest;
import com.thaihoangchuong.bannerservice.payload.response.InformationResponse;

public interface InformationService {
    public UUID addInformation(InformationRequest InformationRequest);
    public List <InformationResponse> getAllInformations();
    public InformationResponse getInformationById (UUID InformationId);
    public InformationResponse editInformation(UUID InformationId, InformationRequest InformationRequest);
    public void deleteInformationById(UUID InformationId);
}
