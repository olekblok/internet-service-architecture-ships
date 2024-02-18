package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutModelRequest {
    private String name;
    private int length_of_ships;
}
