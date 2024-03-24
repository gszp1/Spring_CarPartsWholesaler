package org.example.zadanie1.repository;

import org.example.zadanie1.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> { }
