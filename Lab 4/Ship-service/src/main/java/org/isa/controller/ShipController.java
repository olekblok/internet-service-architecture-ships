package org.isa.controller;

import lombok.RequiredArgsConstructor;
import org.isa.dto.model.GetShipShipNameResponse;
import org.isa.dto.model.GetShipResponse;
import org.isa.dto.model.GetShipsResponse;
import org.isa.dto.model.PutShipRequest;
import org.isa.exception.ShipNotFoundException;
import org.isa.exception.ModelNotFoundException;
import org.isa.service.ShipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ships")
@RequiredArgsConstructor
public class ShipController {
    private final ShipService shipService;

    @PostMapping
    public ResponseEntity<Void> addNewShip(@RequestBody GetShipResponse getShipResponse) {
        getShipResponse.setId(UUID.randomUUID());
        try {
            shipService.addShip(getShipResponse);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ModelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetShipShipNameResponse> getShipById(@PathVariable UUID id) {
        try {
            GetShipShipNameResponse ship = shipService.getShipById(id);
            return new ResponseEntity<>(ship, HttpStatus.OK);
        } catch (ShipNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetShipResponse> updateShip(
            @PathVariable UUID id,
            @RequestBody PutShipRequest putShipRequest) {
        try {
            GetShipResponse updatedShip = shipService.updateShip(id, putShipRequest);
            return new ResponseEntity<>(updatedShip, HttpStatus.OK);
        } catch (ShipNotFoundException | ModelNotFoundException e
        ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShip(@PathVariable UUID id) {
        boolean deleted = shipService.deleteShip(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<GetShipsResponse> getAllShips() {
        GetShipsResponse ships = shipService.getAllShips();
        return new ResponseEntity<>(ships, HttpStatus.OK);
    }
}


