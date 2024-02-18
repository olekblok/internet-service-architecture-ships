package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.GetModelsResponse;
import org.example.dto.GetModelResponse;
import org.example.dto.PutModelRequest;
import org.example.exception.ModelNotFoundException;
import org.example.mapper.ModelMapper;
import org.example.model.Model;
import org.example.repository.ModelRepository;
import org.example.repository.ModelRestRepository;
import org.example.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelRestRepository modelRestRepository;

    @Override
    public void addModel(GetModelResponse getModelResponse) {
        Model model = ModelMapper.mapToModel(getModelResponse);
        modelRestRepository.addModel(getModelResponse);
        modelRepository.save(model);
    }

    @Override
    public GetModelsResponse getAllModels() {
        return ModelMapper.mapToGetModelsResponse(modelRepository.findAll());
    }

    @Override
    public GetModelResponse getModelById(UUID id) {
        Model model = modelRepository
                .findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Model not found: " + id));
        return ModelMapper.mapToGetModelResponse(model);
    }

    @Override
    public boolean deleteModel(UUID id) {
        Model model = modelRepository.findById(id).orElse(null);
        if (model == null) {
            return false;
        }
        modelRestRepository.delete(id);
        modelRepository.delete(model);
        return true;
    }

    @Override
    public GetModelResponse updateModel(UUID id, PutModelRequest putModelRequest) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Model not found: " + id));

        model.setName(putModelRequest.getName());
        if (!model.getName().equalsIgnoreCase(putModelRequest.getName())) {
            modelRestRepository.updateName(id, putModelRequest);
        }
        model.setLength_of_ships(putModelRequest.getLength_of_ships());

        modelRepository.save(model);

        return ModelMapper.mapToGetModelResponse(model);
    }

}
