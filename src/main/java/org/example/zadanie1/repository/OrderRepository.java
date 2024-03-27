package org.example.zadanie1.repository;

import org.example.zadanie1.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Long countByUserEmail(String email);
}
