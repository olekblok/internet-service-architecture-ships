package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.GetModelsResponse;
import org.example.dto.GetModelResponse;
import org.example.dto.PutModelRequest;
import org.example.exception.ModelNotFoundException;
import org.example.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @PostMapping
    public ResponseEntity<Void> addNewModel(@RequestBody GetModelResponse getModelResponse) {
        getModelResponse.setId(UUID.randomUUID());
        modelService.addModel(getModelResponse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetModelResponse> updateModel(
            @PathVariable UUID id,
            @RequestBody PutModelRequest putModelRequest
    ) {
        try {
            GetModelResponse updatedModel = modelService.updateModel(id, putModelRequest);
            return new ResponseEntity<>(updatedModel, HttpStatus.OK);
        } catch (ModelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<GetModelsResponse> getAllModels() {
        GetModelsResponse models = modelService.getAllModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetModelResponse> getModelById(@PathVariable UUID id) {
        try {
            GetModelResponse model = modelService.getModelById(id);
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (ModelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable UUID id) {
        boolean deleted = modelService.deleteModel(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


