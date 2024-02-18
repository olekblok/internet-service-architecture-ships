package org.isa.service;

import org.isa.dto.model.GetShipShipNameResponse;
import org.isa.dto.model.GetShipResponse;
import org.isa.dto.model.GetShipsResponse;
import org.isa.dto.model.PutShipRequest;

import java.util.UUID;

public interface ShipService {
    void addShip(GetShipResponse getShipResponse);


    GetShipsResponse getAllShips();

    boolean deleteShip(UUID id);

    GetShipResponse updateShip(UUID id, PutShipRequest putShipRequest);

    GetShipShipNameResponse getShipById(UUID uuid);
}
