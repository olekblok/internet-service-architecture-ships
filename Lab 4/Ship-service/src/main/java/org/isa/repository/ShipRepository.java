package org.isa.repository;


import org.isa.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShipRepository extends JpaRepository<Ship, UUID> {
    @Override
    List<Ship> findAll();

    @Query("select c from Ship c where c.name = :name and c.cost = :cost")
    Optional<Ship> findShipByNameAndCost(
            @Param("name") String name,
            @Param("cost") int cost);

    Optional<Ship> findByName(String name);
}
