package org.example.service;

import org.example.dto.GetModelsResponse;
import org.example.dto.GetModelResponse;
import org.example.dto.PutModelRequest;

import java.util.UUID;

public interface ModelService {
    void addModel(GetModelResponse getModelResponse);

    GetModelsResponse getAllModels();

    GetModelResponse getModelById(UUID id);

    boolean deleteModel(UUID id);

    GetModelResponse updateModel(UUID id, PutModelRequest putModelRequest);
}
