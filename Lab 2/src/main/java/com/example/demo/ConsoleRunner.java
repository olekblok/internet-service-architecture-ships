package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
@Component
public class ConsoleRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {

            displayMenu();

            int command = scanner.nextInt();
            scanner.nextLine();

            switch(command) {
                case 1:
                    printModels();
                    break;
                case 2:
                    printShips();
                    break;
                case 3:
                    addShip(scanner);
                    break;
                case 4:
                    deleteShip(scanner);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Goodbye and see you soon");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command, try again");
            }

        }
    }

    @Autowired
    private ModelService modelService;

    @Autowired
    private ShipService shipService;

    public void displayMenu() {
        System.out.println("Available commands:");
        System.out.println("1. List all models");
        System.out.println("2. List all ships");
        System.out.println("3. Add ship");
        System.out.println("4. Delete ship");
        System.out.println("5. Exit");

        System.out.println();
        System.out.println("Enter a command (1-5): ");
    }

    public void printModels() {
        List<Model> models = modelService.retrieveAllModels();
        models.forEach(model -> System.out.println("ID: " + model.getId() + " Name: " + model.getName()));
    }

    public void printShips() {
        List<Ship> ships = shipService.getAllShips();
        ships.forEach(ship -> System.out.println("ID: " + ship.getId()
                + " Name: " + ship.getName()
                + " Cost: " + ship.getCost()
                + " Model: " + ship.getModel().getName()));
    }

    public void addShip(Scanner scanner) {
        System.out.println("Type in name of the ship");
        String shipName = scanner.nextLine();
        System.out.println("Type in the cost of the ship");
        long cost = scanner.nextLong();
        scanner.nextLine();

        // Display available models (restaurants)
        System.out.println("Available models for the ship: ");
        List<Model> availableModels = modelService.retrieveAllModels();
        availableModels.forEach(model -> System.out.println("ID: " + model.getId() + " Name: " + model.getName()));
        System.out.println();
        System.out.println("Type in the ID of the model that the ship is associated with.");
        String modelIdInput = scanner.nextLine();

        UUID modelId;

        try {
            modelId = UUID.fromString(modelIdInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid model ID format. Ship not added.");
            return;
        }

        Model selectedModel = modelService.getModelByID(modelId);
        if (selectedModel == null) {
            System.out.println("Invalid model. Ship not added.");
        } else {
            Ship newShip = new Ship(UUID.randomUUID(), shipName, cost, selectedModel);
            shipService.saveShip(newShip);
            System.out.println("Ship added successfully.");
        }
    }

    public void deleteShip(Scanner scanner) {
        System.out.println("Here are available ships: ");
        List<Ship> allShips = shipService.getAllShips();
        allShips.forEach(ship -> System.out.println("ID: " + ship.getId()
                + " Name: " + ship.getName()
                + " Cost: " + ship.getCost()
                + " Model: " + ship.getModel().getName()));

        System.out.println();
        System.out.println("Type in the ID of the ship that you would like to delete.");
        String shipIdInput = scanner.nextLine();
        UUID shipId = UUID.fromString(shipIdInput);
        try {
            Ship selectedShip = shipService.getShipById(shipId);
            shipService.deleteShip(selectedShip);
            System.out.println("Ship deleted successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ship ID format. Ship not deleted");
        }
    }
}
