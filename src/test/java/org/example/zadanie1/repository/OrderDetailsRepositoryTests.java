package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.Order;
import org.example.zadanie1.model.OrderDetails;
import org.example.zadanie1.model.Part;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderDetailsRepositoryTests {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void populateTables() {
        populatePartsTable();
        populateOrdersTable();
        populateOrderDetailsTable();
    }

    private void populatePartsTable() {
        partRepository.saveAll(Arrays.asList(
                        new Part("Oil Filter", new BigDecimal("22.5"), 10L),
                        new Part("Air Filter", new BigDecimal("10.5"), 40L),
                        new Part("Seat", new BigDecimal("100.25"), 5L)
                )
        );
    }

    private void populateOrdersTable() {
        orderRepository.saveAll(Arrays.asList(
                        new Order(LocalDate.now(), LocalDate.now().plusDays(1), 1),
                        new Order(LocalDate.now(), LocalDate.now().plusDays(2), 1)
                )
        );
    }

    private void populateOrderDetailsTable() {
        Optional<Order> firstOrder = orderRepository.findById(1L);
        if (firstOrder.isEmpty()) {
            return;
        }
        Optional<Part> firstPart = partRepository.findById(1L);
        if (firstPart.isEmpty()) {
            return;
        }
        orderDetailsRepository.save(new OrderDetails(
                        firstPart.get(),
                        firstOrder.get(),
                        5L,
                        firstPart.get().getUnitPrice()
                )
        );
    }

    @Test
    public void orderDetailsInTable_CountOrderedProducts_CorrectNumberOfProducts() {
        assertEquals(5L, orderDetailsRepository.sumOrderedParts("Oil Filter"));
    }

}
