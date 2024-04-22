package com.thaihoangchuong.bannerservice.controller;

import com.thaihoangchuong.bannerservice.payload.request.InformationRequest;
import com.thaihoangchuong.bannerservice.payload.response.InformationResponse;
import com.thaihoangchuong.bannerservice.service.InformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("banner-services/api/informations")
public class InformationController {

    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @PostMapping("/create")
    public ResponseEntity<InformationResponse> createInformation(@RequestBody InformationRequest informationRequest) {
        InformationResponse createdInformation = informationService.create(informationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInformation);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<InformationResponse> getInformationById(@PathVariable UUID id) {
        InformationResponse informationResponse = informationService.getById(id);
        if (informationResponse != null) {
            return ResponseEntity.ok(informationResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<InformationResponse>> getAllInformations() {
        List<InformationResponse> informationResponses = informationService.getAll();
        return ResponseEntity.ok(informationResponses);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InformationResponse> updateInformation(@PathVariable UUID id, @RequestBody InformationRequest informationRequest) {
        InformationResponse updatedInformation = informationService.update(id, informationRequest);
        if (updatedInformation != null) {
            return ResponseEntity.ok(updatedInformation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<InformationResponse> deleteInformation(@PathVariable UUID id) {
        InformationResponse deletedInformation = informationService.delete(id);
        if (deletedInformation != null) {
            return ResponseEntity.ok(deletedInformation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
