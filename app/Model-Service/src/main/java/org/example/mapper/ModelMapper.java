package org.example.mapper;

import org.example.dto.GetModelsResponse;
import org.example.dto.GetModelResponse;
import org.example.model.Model;

import java.util.List;

public class ModelMapper {

    public static Model mapToModel(GetModelResponse getModelResponse) {
        return Model.builder()
                .id(getModelResponse.getId())
                .length_of_ships(getModelResponse.getLength_of_ships())
                .name(getModelResponse.getName())
                .build();
    }

    public static GetModelResponse mapToGetModelResponse(Model model) {
        return GetModelResponse.builder()
                .id(model.getId())
                .length_of_ships(model.getLength_of_ships())
                .name(model.getName())
                .build();
    }

    public static GetModelsResponse mapToGetModelsResponse(List<Model> models) {
        return GetModelsResponse.builder()
                .models(models.stream()
                        .map(ModelMapper::mapToGetModelResponse)
                        .toList())
                .build();
    }

}
