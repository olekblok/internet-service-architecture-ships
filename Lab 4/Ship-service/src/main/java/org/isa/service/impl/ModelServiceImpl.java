package org.isa.service.impl;


import lombok.RequiredArgsConstructor;
import org.isa.dto.ship.GetModelResponse;
import org.isa.dto.ship.PutModelRequest;
import org.isa.exception.ModelNotFoundException;
import org.isa.mapper.ModelMapper;
import org.isa.model.Model;
import org.isa.repository.ModelRepository;
import org.isa.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    public void addModel(GetModelResponse getModelResponse) {
        Model model = ModelMapper.mapToModel(getModelResponse);
        modelRepository.save(model);
    }

    @Override
    public boolean deleteModel(UUID id) {
        Model model = modelRepository.findById(id).orElse(null);
        if (model == null) {
            return false;
        }
        modelRepository.delete(model);
        return true;
    }

    @Override
    public GetModelResponse updateModel(UUID id, PutModelRequest putModelRequest) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Model not found: " + id));
        model.setName(putModelRequest.getName());

        modelRepository.save(model);

        return ModelMapper.mapToGetModelResponse(model);
    }

    @Override
    public List<GetModelResponse> getAllModels() {
        return modelRepository.findAll().stream().map(ModelMapper::mapToGetModelResponse).toList();
    }

    @Override
    public GetModelResponse getModelById(UUID id) {
        return ModelMapper.mapToGetModelResponse(modelRepository
                .findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Model not found: " + id)));
    }
}
