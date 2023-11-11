package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;


@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Ship implements Comparable<Ship>, Serializable {
    private final String name;
    private final long cost;
    private final Model model;

    @Override
    public int compareTo(Ship other) {
        int categoryComparison = this.model.getName().compareTo(other.model.getName());
        if (categoryComparison == 0) {
            return Long.compare(this.cost, other.cost);
        }
        return categoryComparison;
    }
}
