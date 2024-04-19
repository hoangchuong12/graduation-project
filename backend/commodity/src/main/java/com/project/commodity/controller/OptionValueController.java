package com.project.commodity.controller;

import com.project.commodity.payload.request.OptionValueRequest;
import com.project.commodity.payload.response.OptionValueResponse;
import com.project.commodity.service.OptionValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/PRODUCTS-SERVICE/api/option-values")
@RequiredArgsConstructor
public class OptionValueController {

    private final OptionValueService optionValueService;

    @PostMapping
    public ResponseEntity<UUID> addOptionValue(@RequestBody OptionValueRequest request) {
        UUID optionValueId = optionValueService.addOptionValue(request);
        return new ResponseEntity<>(optionValueId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OptionValueResponse>> getAllOptionValues() {
        List<OptionValueResponse> optionValues = optionValueService.getAllOptionValues();
        return new ResponseEntity<>(optionValues, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionValueResponse> getOptionValueById(@PathVariable("id") UUID optionValueId) {
        OptionValueResponse optionValue = optionValueService.getOptionValueById(optionValueId);
        return new ResponseEntity<>(optionValue, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionValueResponse> editOptionValue(@PathVariable("id") UUID optionValueId, @RequestBody OptionValueRequest request) {
        OptionValueResponse updatedOptionValue = optionValueService.editOptionValue(optionValueId, request);
        return new ResponseEntity<>(updatedOptionValue, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionValue(@PathVariable("id") UUID optionValueId) {
        optionValueService.deleteOptionValueById(optionValueId);
        return ResponseEntity.noContent().build();
    }
}
