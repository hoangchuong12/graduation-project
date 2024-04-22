package com.thaihoangchuong.bannerservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.thaihoangchuong.bannerservice.entity.Information;
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
    public InformationResponse create(InformationRequest informationRequest) {
        Information information = new Information();
        mapRequestToEntity(informationRequest, information);
        Information savedInformation = informationRepository.save(information);
        return mapInformationToInformationResponse(savedInformation);
    }

    @Override
    public InformationResponse getById(UUID id) {
        Information information = informationRepository.findById(id).orElse(null);
        if (information != null) {
            return mapInformationToInformationResponse(information);
        }
        return null;
    }

    @Override
    public List<InformationResponse> getAll() {
        List<Information> informations = informationRepository.findAll();
        return informations.stream()
                .map(this::mapInformationToInformationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public InformationResponse update(UUID id, InformationRequest informationRequest) {
        Information existingInformation = informationRepository.findById(id).orElse(null);
        if (existingInformation != null) {
            mapRequestToEntity(informationRequest, existingInformation);
            Information updatedInformation = informationRepository.save(existingInformation);
            return mapInformationToInformationResponse(updatedInformation);
        }
        return null;
    }

    @Override
    public InformationResponse delete(UUID id) {
        Information information = informationRepository.findById(id).orElse(null);
        if (information != null) {
            informationRepository.delete(information);
            return mapInformationToInformationResponse(information);
        }
        return null;
    }

    private InformationResponse mapInformationToInformationResponse(Information information) {
        if (information != null) {
            return InformationResponse.builder()
                    .id(information.getId())
                    .Name(information.getName())
                    .logo(information.getLogo())
                    .Address(information.getAddress())
                    .Email(information.getEmail())
                    .Phone(information.getPhone())
                    .BusinessNumber(information.getBusinessNumber())
                    .License(information.getLicense())
                    .Represent(information.getRepresent())
                    .RepresentPhone(information.getRepresentPhone())
                    .UpdatedBy(information.getUpdatedBy())
                    .build();
        }
        return null;
    }
    

    private void mapRequestToEntity(InformationRequest informationRequest, Information information) {
        BeanUtils.copyProperties(informationRequest, information);
    }
}
