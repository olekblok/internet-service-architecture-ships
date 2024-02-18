package org.example.repository;

import org.example.dto.GetModelResponse;
import org.example.dto.PutModelRequest;

import java.util.UUID;

public interface ModelRestRepository {
    void delete(UUID id);

    void updateName(UUID id, PutModelRequest putModelRequest);

    void addModel(GetModelResponse getModelResponse);
}
