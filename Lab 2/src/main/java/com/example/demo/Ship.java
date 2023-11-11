package com.example.demo;


import lombok.*;
import java.io.Serializable;
import jakarta.persistence.*;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "ships")
@Entity
public class Ship implements Comparable<Ship>, Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "ship_name")
    private String name;

    @Column(name = "cost_of_ship")
    private long cost;

    @ManyToOne
    @JoinColumn(name = "model_id")
    @EqualsAndHashCode.Exclude private Model model;

    @Override
    public int compareTo(Ship other) {
        int categoryComparison = this.model.getName().compareTo(other.model.getName());
        if (categoryComparison == 0) {
            return Long.compare(this.cost, other.cost);
        }
        return categoryComparison;
    }
}
