package org.example.zadanie1.repository;

import org.example.zadanie1.model.Model;
import org.springframework.data.repository.CrudRepository;

public interface CarModelRepository extends CrudRepository<Model, Long> { }
