package com.project.commodity.controller;

import com.project.commodity.payload.request.OptionRequest;
import com.project.commodity.payload.response.OptionResponse;
import com.project.commodity.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/options")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @PostMapping
    public ResponseEntity<UUID> addOption( @RequestBody OptionRequest request) {
        UUID optionId = optionService.addOption(request);
        return new ResponseEntity<>(optionId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OptionResponse>> getAllOptions() {
        List<OptionResponse> options = optionService.getAllOptions();
        return new ResponseEntity<>(options, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionResponse> getOptionById(@PathVariable("id") UUID optionId) {
        OptionResponse option = optionService.getOptionById(optionId);
        return new ResponseEntity<>(option, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionResponse> editOption(@PathVariable("id") UUID optionId,  @RequestBody OptionRequest request) {
        OptionResponse updatedOption = optionService.editOption(optionId, request);
        return new ResponseEntity<>(updatedOption, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable("id") UUID optionId) {
        optionService.deleteOptionById(optionId);
        return ResponseEntity.noContent().build();
    }
}
