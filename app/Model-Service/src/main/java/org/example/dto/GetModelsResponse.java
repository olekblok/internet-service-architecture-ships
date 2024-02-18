package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class GetModelsResponse {
    @Singular
    private List<GetModelResponse> models;
}
