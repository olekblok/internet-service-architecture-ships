package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ShipDto {
    private final String name;
    private final long cost;
    private final String model;
}
