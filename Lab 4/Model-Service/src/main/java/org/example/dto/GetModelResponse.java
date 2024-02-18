package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetModelResponse {
    private UUID id;
    private String name;
    private int length_of_ships;
}
