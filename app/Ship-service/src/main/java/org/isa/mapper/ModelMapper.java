package org.isa.mapper;


import org.isa.dto.ship.GetModelResponse;
import org.isa.model.Model;

public class ModelMapper {

    public static Model mapToModel(GetModelResponse getModelResponse) {
        return Model.builder()
                .id(getModelResponse.getId())
                .name(getModelResponse.getName())
                .build();
    }

    public static GetModelResponse mapToGetModelResponse(Model model) {
        return GetModelResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
