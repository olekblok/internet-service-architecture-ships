package com.example.demo;


import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, ExecutionException, InterruptedException {
        // Create models and ships (as provided)
        Model model1 = new Model("Leopard 80", 24, new ArrayList<>());
        Model model2 = new Model("Azimut 80", 17, new ArrayList<>());

        Ship ship1 = new Ship("Catarina", 270000, model1);
        Ship ship2 = new Ship("Zeus", 350000, model1);
        Ship ship3 = new Ship("Dutchman", 249999, model2);

        model1.getShips().add(ship1);
        model1.getShips().add(ship2);
        model2.getShips().add(ship3);



        List<Model> models = Arrays.asList(model1, model2);

        System.out.println("TASK 2 !!!!!!!!!!!!");
        for (Model model : models) {
            System.out.println(model.getName() + " Length of ship = " + model.getLength_of_ship());
            for (Ship ship : model.getShips()) {
                System.out.println(ship);
            }
        }
        Set<Ship> allShips = models.stream()
                .flatMap(model -> model.getShips().stream())
                .collect(Collectors.toSet());

        System.out.println("TASK 3 !!!!!!!!!!!!");
        System.out.println("All Ships:");
        allShips.forEach(ship -> {
            System.out.println("Ship: Name=" + ship.getName() + ", Cost=" + ship.getCost() + ", Model=" + ship.getModel().getName());
        });

        System.out.println("TASK 4 !!!!!!!!!!!!");
        long selectedCostThreshold = 250000;
        Set<Ship> filteredShips = allShips.stream()
                .filter(ship -> ship.getCost() > selectedCostThreshold)
                .sorted(Comparator.comparing(Ship::getName))
                .collect(Collectors.toSet());

        // Print the sorted ships
        System.out.println("Filtered and Sorted Ships (by cost):");
        filteredShips.forEach(ship -> {
            System.out.println("Ship: Name=" + ship.getName() + ", Cost=" + ship.getCost() + ", Model=" + ship.getModel().getName());
        });

        System.out.println("TASK 5 !!!!!!!!!!!!");
        List<ShipDto> shipDtos = filteredShips.stream()
                .map(ship -> new ShipDto(ship.getName(), ship.getCost(), ship.getModel().getName()))
                .sorted(Comparator.comparing(ShipDto::getName))
                .toList();

        shipDtos.forEach(shipDto -> System.out.println("ShipDto: Name=" + shipDto.getName() + ", Cost=" + shipDto.getCost() + ", Model=" + shipDto.getModel()));

        System.out.println("TASK 6 !!!!!!!!!!!!");
        FileOutputStream fileOutputStream
                = new FileOutputStream("yourfile.ser");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(models);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("yourfile.ser");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        List<Model> r1 = (List<Model>) objectInputStream.readObject();
        objectInputStream.close();

        for (Model model : r1) {
            System.out.println(model.getName() + " length ship = " + model.getLength_of_ship());
            for (Ship ship : model.getShips()) {
                System.out.println(ship.getName());
            }
        }

        System.out.println("TASK 7 !!!!!!!!!!!!!");
        int [] threadPoolSizes = {1, 2, 4};
        for (int poolSize : threadPoolSizes) {
            ForkJoinPool customThreadPool = new ForkJoinPool(poolSize);
            customThreadPool.submit(() -> {
                allShips.parallelStream().forEach(ship -> {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Printing ship: " + ship.getName()
                                + " model " + ship.getModel().getName()
                                + " at cost " + ship.getCost() + " in Thread: " + Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }).get();
        }
    }
}
