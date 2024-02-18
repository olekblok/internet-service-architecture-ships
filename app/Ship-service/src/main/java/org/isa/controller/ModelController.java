package org.isa.controller;

import lombok.RequiredArgsConstructor;
import org.isa.dto.ship.GetModelResponse;
import org.isa.dto.ship.PutModelRequest;
import org.isa.exception.ModelNotFoundException;
import org.isa.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @PostMapping
    public ResponseEntity<Void> addNewModel(@RequestBody GetModelResponse getModelResponse) {
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
    public ResponseEntity<List<GetModelResponse>> getAllModels() {
        List<GetModelResponse> models = modelService.getAllModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
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


