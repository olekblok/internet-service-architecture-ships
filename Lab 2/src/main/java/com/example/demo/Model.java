package com.example.demo;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "models")
public class Model implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "model_name")
    private String name;

    @Column(name = "length_of_ship")
    private int length_of_ship;

    @OneToMany(mappedBy = "model")
    private List<Ship> ships;
}

