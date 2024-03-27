package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.checkerframework.checker.units.qual.A;
import org.example.zadanie1.compositekey.OrderDetailsKey;
import org.example.zadanie1.model.Order;
import org.example.zadanie1.model.OrderDetails;
import org.example.zadanie1.model.Part;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @AfterEach
    public void cleanTables() {
        partRepository.deleteAll();
        orderDetailsRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    public void partOrdersCountTest() {
        // Insert into database example parts
        List<Part> parts = new ArrayList<>();
        parts.add(new Part("Oil Filter", new BigDecimal("22.5"), 10L));
        parts.add(new Part("Air Filter", new BigDecimal("10.5"), 40L));
        parts.add(new Part("Seat", new BigDecimal("100.25"), 5L));
        partRepository.saveAll(parts);

        // Create Orders
        List<Order> orders = new ArrayList<>();
        Order order = new Order(LocalDate.now(), LocalDate.now().plusDays(1), 1);
        orderRepository.save(order);
        Order order2 = new Order(LocalDate.now(), LocalDate.now().plusDays(2), 1);
        orderRepository.save(order2);

        // Create Order detail
        OrderDetails orderDetails = new OrderDetails(new OrderDetailsKey(parts.getFirst().getId(), order.getId()),
                parts.getFirst(),
                order,
                3L,
                parts.getFirst().getUnitPrice()
        );
        orderDetailsRepository.save(orderDetails);
        OrderDetails orderDetails2 = new OrderDetails(new OrderDetailsKey(parts.getFirst().getId(), order2.getId()),
                parts.getFirst(),
                order2,
                3L,
                parts.getFirst().getUnitPrice()
        );
        orderDetailsRepository.save(orderDetails2);
        assertEquals(2, orderDetailsRepository.countByPartName(parts.getFirst().getName()));
    }
}
