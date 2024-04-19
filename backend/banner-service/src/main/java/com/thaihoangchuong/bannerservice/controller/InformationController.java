package com.thaihoangchuong.bannerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.thaihoangchuong.bannerservice.payload.request.InformationRequest;
import com.thaihoangchuong.bannerservice.payload.response.InformationResponse;
import com.thaihoangchuong.bannerservice.service.InformationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/BANNER-SERVICE/api/information")
public class InformationController {

    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @PostMapping
    public ResponseEntity<UUID> addInformation(@RequestBody InformationRequest request) {
        UUID informationId = informationService.addInformation(request);
        return new ResponseEntity<>(informationId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InformationResponse>> getAllInformations() {
        List<InformationResponse> allInformations = informationService.getAllInformations();
        return new ResponseEntity<>(allInformations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformationResponse> getInformationById(@PathVariable("id") UUID informationId) {
        InformationResponse informationResponse = informationService.getInformationById(informationId);
        return new ResponseEntity<>(informationResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformationResponse> editInformation(@PathVariable("id") UUID informationId, @RequestBody InformationRequest request) {
        InformationResponse editedInformation = informationService.editInformation(informationId, request);
        return new ResponseEntity<>(editedInformation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformationById(@PathVariable("id") UUID informationId) {
        informationService.deleteInformationById(informationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
