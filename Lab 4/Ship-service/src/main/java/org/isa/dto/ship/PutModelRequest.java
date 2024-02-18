package org.isa.dto.ship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutModelRequest {
    private String name;
}
