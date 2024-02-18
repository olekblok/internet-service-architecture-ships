package org.isa.mapper;

import org.isa.dto.model.GetShipShipNameResponse;
import org.isa.dto.model.GetShipResponse;
import org.isa.dto.model.GetShipsResponse;
import org.isa.model.Ship;
import org.isa.model.Model;

import java.util.List;

public class ShipMapper {
    public static GetShipResponse mapToShipDto(Ship ship) {

        return GetShipResponse.builder()
                .modelId(ship.getModel().getId())
                .id(ship.getId())
                .name(ship.getName())
                .cost(ship.getCost())
                .build();
    }

    public static GetShipShipNameResponse mapToGetShipDto(Ship ship) {
        return GetShipShipNameResponse.builder()
                .model_name(ship.getModel().getName())
                .id(ship.getId())
                .name(ship.getName())
                .cost(ship.getCost())
                .build();
    }

    public static Ship mapToShip(GetShipResponse getShipResponse, Model model) {
        return Ship.builder()
                .id(getShipResponse.getId())
                .model(model)
                .name(getShipResponse.getName())
                .cost(getShipResponse.getCost())
                .build();
    }

    public static GetShipsResponse mapToGetShipsResponse(List<Ship> ships) {
        return GetShipsResponse.builder()
                .ships(ships.stream()
                        .map(ShipMapper::mapToShipDto)
                        .toList())
                .build();
    }
}
