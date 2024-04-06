package org.example.zadanie1.repository;

import org.example.zadanie1.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> { }
