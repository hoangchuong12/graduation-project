package com.thaihoangchuong.bannerservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.thaihoangchuong.bannerservice.entity.Information;
import com.thaihoangchuong.bannerservice.exception.InformationServiceCustomException;
import com.thaihoangchuong.bannerservice.payload.request.InformationRequest;
import com.thaihoangchuong.bannerservice.payload.response.InformationResponse;
import com.thaihoangchuong.bannerservice.repository.InformationRepository;
import com.thaihoangchuong.bannerservice.service.InformationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;

    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public UUID addInformation(InformationRequest request) {
        Information information = new Information();
        BeanUtils.copyProperties(request, information);
        Information savedInformation = informationRepository.save(information);
        return savedInformation.getId();
    }

    @Override
    public List<InformationResponse> getAllInformations() {
        return informationRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public InformationResponse getInformationById(UUID informationId) {
        Information information = informationRepository.findById(informationId)
                .orElseThrow(() -> new InformationServiceCustomException("Information with given ID not found", "information_not_found"));
        return convertToResponse(information);
    }

    @Override
    public InformationResponse editInformation(UUID informationId, InformationRequest request) {
        Information information = informationRepository.findById(informationId)
                .orElseThrow(() -> new InformationServiceCustomException("Information with given ID not found", "information_not_found"));
        BeanUtils.copyProperties(request, information);
        Information savedInformation = informationRepository.save(information);
        return convertToResponse(savedInformation);
    }

    @Override
    public void deleteInformationById(UUID informationId) {
        informationRepository.deleteById(informationId);
    }

    private InformationResponse convertToResponse(Information information) {
        InformationResponse response = new InformationResponse();
        BeanUtils.copyProperties(information, response);
        return response;
    }
}
