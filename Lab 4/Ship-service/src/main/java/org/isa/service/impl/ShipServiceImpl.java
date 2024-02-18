package org.isa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.isa.dto.model.GetShipShipNameResponse;
import org.isa.dto.model.GetShipResponse;
import org.isa.dto.model.GetShipsResponse;
import org.isa.dto.model.PutShipRequest;
import org.isa.exception.ShipNotFoundException;
import org.isa.exception.ModelNotFoundException;
import org.isa.mapper.ShipMapper;
import org.isa.model.Ship;
import org.isa.model.Model;
import org.isa.repository.ShipRepository;
import org.isa.repository.ModelRepository;
import org.isa.service.ShipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelRepository modelRepository;

    @Override
    public void addShip(GetShipResponse getShipResponse) {
        Model model = modelRepository.findById(getShipResponse.getModelId())
                .orElseThrow(() -> new ModelNotFoundException("Model not found: " + getShipResponse.getModelId()));
        Ship ship = ShipMapper.mapToShip(getShipResponse, model);
        shipRepository.save(ship);
    }

    @Override
    public GetShipsResponse getAllShips() {
        List<Ship> ships = shipRepository.findAll();
        return ShipMapper.mapToGetShipsResponse(ships);
    }

    @Override
    public boolean deleteShip(UUID id) {
        Ship ship = shipRepository.findById(id).orElse(null);
        if (ship == null) {
            return false;
        }
        shipRepository.delete(ship);
        return true;
    }

    @Override
    public GetShipResponse updateShip(UUID id, PutShipRequest putShipRequest) {
        Ship existingShip = shipRepository.findById(id)
                .orElseThrow(() -> new ShipNotFoundException("Ship not found: " + id));
        existingShip.setName(putShipRequest.getName());
        existingShip.setCost(putShipRequest.getCost());

        shipRepository.save(existingShip);

        return ShipMapper.mapToShipDto(existingShip);
    }

    @Override
    public GetShipShipNameResponse getShipById(UUID uuid) {
        Ship ship = shipRepository.findById(uuid)
                .orElseThrow(() -> new ShipNotFoundException("Ship not found: " + uuid));
        return ShipMapper.mapToGetShipDto(ship);
    }
}




