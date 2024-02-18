package org.isa.dto.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class GetShipsResponse {

    @Singular
    private List<GetShipResponse> ships;

}
