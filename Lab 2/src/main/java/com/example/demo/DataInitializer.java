package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private final ModelService modelService;
    private final ShipService shipService;

    @Autowired
    public DataInitializer(ModelService modelService, ShipService shipService) {
        this.modelService = modelService;
        this.shipService = shipService;
    }

    @PostConstruct
    public void initializeData() {

            Model model1 = new Model(UUID.randomUUID(),"Leopard 80", 24, null);
            Model model2 = new Model(UUID.randomUUID(),"Azimut 80", 17,null);

            model1 = modelService.saveModel(model1);
            model2 = modelService.saveModel(model2);

            Ship ship1 = new Ship(UUID.randomUUID(), "Catarina", 270000, model1);
            Ship ship2 = new Ship(UUID.randomUUID(), "Zeus", 350000, model1);
            Ship ship3 = new Ship(UUID.randomUUID(), "Dutchman", 249999, model2);
            shipService.saveShip(ship1);
            shipService.saveShip(ship2);
            shipService.saveShip(ship3);
        }
    }
