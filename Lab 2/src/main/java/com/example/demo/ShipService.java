package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShipService {
    private final ShipRepository shipRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public List<Ship> getShipsByModel(Model model) {
        return shipRepository.findByModel(model);
    }

    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    public void saveShip(Ship ship) {
        shipRepository.save(ship);
    }

    public void deleteShip(Ship ship) {
        shipRepository.delete(ship);
    }

    public Ship getShipById(UUID worker_ID) {
        return shipRepository.findById(worker_ID).orElse(null);
    }
}


