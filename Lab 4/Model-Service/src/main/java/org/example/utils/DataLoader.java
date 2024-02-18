package org.example.utils;

import jakarta.annotation.PostConstruct;
import org.example.model.Model;
import org.example.repository.ModelRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataLoader {


    private final ModelRepository modelRepository;

    public DataLoader(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    private static List<Model> loadModels() {
        List<Model> listOfModels = new ArrayList<>();
        listOfModels.add(Model.builder().id(UUID.fromString("e340ba5d-de57-47db-a56f-5bd788f4d183"))
                .name("Leopard 40").length_of_ships(14).build());

        listOfModels.add(Model.builder().id(UUID.fromString("3851dc62-52b7-481a-adcd-0287c16298b5"))
                .name("Leopard 20").length_of_ships(7).build());

        listOfModels.add(Model.builder().id(UUID.fromString("fd08d341-a0b4-4a32-8251-903178a6daa4"))
                .name("Azimut 70").length_of_ships(13).build());

        listOfModels.add(Model.builder().id(UUID.fromString("df6dfefa-107d-4791-84be-f548b1a9a902"))
                .name("Azimut 80").length_of_ships(10).build());

        return listOfModels;
    }

    @PostConstruct
    public void persistData() {
        List<Model> listOfModels = DataLoader.loadModels();
        modelRepository.saveAll(listOfModels);
    }
}
