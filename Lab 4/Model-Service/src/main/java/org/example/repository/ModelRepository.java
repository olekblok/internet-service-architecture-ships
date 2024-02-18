package org.example.repository;

import org.example.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
    Optional<Model> findByName(String name);

    @Override
    List<Model> findAll();

    Model getModelByName(String name);
}
