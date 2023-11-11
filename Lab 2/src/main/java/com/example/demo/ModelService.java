package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> retrieveAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelByID(UUID model_ID) {
        return modelRepository.findById(model_ID).orElse(null);
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }
}
