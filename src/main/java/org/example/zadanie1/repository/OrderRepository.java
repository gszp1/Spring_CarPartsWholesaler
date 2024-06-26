package org.example.zadanie1.repository;

import org.example.zadanie1.model.Order;
import org.example.zadanie1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Long countByUser(User user);

    Long countByOrderDetailsPartName(String name);
}
