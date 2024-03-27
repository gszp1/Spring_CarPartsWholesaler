package org.example.zadanie1.repository;

import org.example.zadanie1.model.Part;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PartRepository extends CrudRepository<Part, Long> {

    List<Part> findByUnitPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
}
