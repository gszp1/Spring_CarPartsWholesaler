package org.example.zadanie1.repository;

import org.example.zadanie1.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> { }
