package org.example.zadanie1.repository;

import org.example.zadanie1.compositekey.OrderDetailsKey;
import org.example.zadanie1.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsKey> {

    Long countByPartName(String name);

    @Query("SELECT SUM(od.quantity) FROM OrderDetails od WHERE od.part.name = :name")
    Long sumOrderedParts(@Param("name") String name);
}
