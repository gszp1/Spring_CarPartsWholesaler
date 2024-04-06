package org.example.zadanie1.repository;

import org.example.zadanie1.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Long countByUserEmail(String email);

    Optional<Order> findFirst();
}
