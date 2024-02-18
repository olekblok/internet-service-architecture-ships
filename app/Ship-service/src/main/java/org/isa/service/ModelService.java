package org.isa.service;


import org.isa.dto.ship.GetModelResponse;
import org.isa.dto.ship.PutModelRequest;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    void addModel(GetModelResponse getModelResponse);

    boolean deleteModel(UUID id);

    GetModelResponse updateModel(UUID id, PutModelRequest putModelRequest);

    List<GetModelResponse> getAllModels();

    GetModelResponse getModelById(UUID id);
}
