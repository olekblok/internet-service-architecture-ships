package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Model implements Serializable {
    private final String name;
    private final int length_of_ship;
    private final List<Ship> ships;
}

