package org.isa.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetShipShipNameResponse {
    private UUID id;
    private String name;
    private int cost;
    @JsonProperty("model_name")
    private String model_name;
}
