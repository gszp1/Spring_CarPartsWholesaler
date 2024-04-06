package org.example.zadanie1.repository;

import org.example.zadanie1.compositekey.OrderDetailsKey;
import org.example.zadanie1.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsKey> {

    Long countByPartName(String name);
}
