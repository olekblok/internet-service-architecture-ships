package org.isa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "ships")
@AllArgsConstructor
@NoArgsConstructor
public class Ship implements Serializable {
    @Id
    @Column(unique = true)
    private UUID id;
    private String name;
    private int cost;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
