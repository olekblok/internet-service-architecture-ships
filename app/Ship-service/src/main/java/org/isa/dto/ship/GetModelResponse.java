package org.isa.dto.ship;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetModelResponse {
    private UUID id;
    private String name;
}
