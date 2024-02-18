package org.isa.utils;

import jakarta.annotation.PostConstruct;
import org.isa.model.Ship;
import org.isa.model.Model;
import org.isa.repository.ShipRepository;
import org.isa.repository.ModelRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader {


    private final ShipRepository shipRepository;
    private final ModelRepository modelRepository;

    public DataLoader(ShipRepository shipRepository, ModelRepository modelRepository) {
        this.shipRepository = shipRepository;
        this.modelRepository = modelRepository;
    }

    @PostConstruct
    public void persistData() {
        List<Model> models = loadModels();
        modelRepository.saveAll(models);
        List<Ship> listOfShips = loadShips(models);
        loadShipsToModel(models, listOfShips);
        shipRepository.saveAll(listOfShips);
        modelRepository.saveAll(models);

    }

    public void loadShipsToModel(List<Model> models, List<Ship> listOfShips) {
        models.get(0).setShips(Arrays.asList(listOfShips.get(0), listOfShips.get(1)));
        models.get(0).setShips(Arrays.asList(listOfShips.get(2), listOfShips.get(3)));
        models.get(0).setShips(Arrays.asList(listOfShips.get(4), listOfShips.get(5)));
        models.get(0).setShips(Collections.singletonList(listOfShips.get(6)));

    }


    public List<Ship> loadShips(List<Model> models) {
        List<Ship> listOfShips = new ArrayList<>();
        List<UUID> uuids = Arrays.asList(
                UUID.fromString("aa2b6af2-3c14-4784-b524-110798769d72"),
                UUID.fromString("1c2b8bdb-f83f-4594-a18b-4073ec5b5afb"),
                UUID.fromString("055555d6-1cd0-4268-a519-176381ed2799"),
                UUID.fromString("8b0454ff-e4f7-4d4d-ae16-4c84162a1c5a"),
                UUID.fromString("445cfb56-ca51-4da3-b244-dfc108460981"),
                UUID.fromString("04dbe36d-e6ca-4030-a3e9-b202967de4cd"),
                UUID.fromString("9d1d3e0a-bb79-4de4-a836-87ca02216846")

        );
        listOfShips.add(Ship.builder().id(uuids.get(0))
                .name("Dutchman").cost(4)
                .model(models.get(0)).build());
        listOfShips.add(Ship.builder().id(uuids.get(1))
                .name("Catarina").cost(2)
                .model(models.get(0)).build());
        listOfShips.add(Ship.builder().id(uuids.get(2))
                .name("Nevada").cost(4)
                .model(models.get(1)).build());
        listOfShips.add(Ship.builder().id(uuids.get(3))
                .name("Naiomi").cost(4)
                .model(models.get(1)).build());
        listOfShips.add(Ship.builder().id(uuids.get(4))
                .name("Lancelot").cost(4)
                .model(models.get(2)).build());
        listOfShips.add(Ship.builder().id(uuids.get(5))
                .name("Andrew").cost(4)
                .model(models.get(2)).build());
        listOfShips.add(Ship.builder().id(uuids.get(6))
                .name("Fonfara").cost(4)
                .model(models.get(3)).build());
        return listOfShips;
    }

    public List<Model> loadModels() {
        List<Model> listOfModels = new ArrayList<>();
        listOfModels.add(Model.builder().id(UUID.fromString("e340ba5d-de57-47db-a56f-5bd788f4d183"))
                .name("Leopard 40").build());

        listOfModels.add(Model.builder().id(UUID.fromString("3851dc62-52b7-481a-adcd-0287c16298b5"))
                .name("Leopard 20").build());

        listOfModels.add(Model.builder().id(UUID.fromString("fd08d341-a0b4-4a32-8251-903178a6daa4"))
                .name("Azimut 70").build());

        listOfModels.add(Model.builder().id(UUID.fromString("df6dfefa-107d-4791-84be-f548b1a9a902"))
                .name("Azimut 80").build());

        return listOfModels;
    }

}
