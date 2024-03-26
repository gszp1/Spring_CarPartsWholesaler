package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository orderRepository;

    @AfterEach
    public void cleanTable() {
        orderRepository.deleteAll();
    }

    @Test
    public void getOrdersCountTest() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            orders.add(new Order(LocalDate.now(), LocalDate.now().plusDays(i), 1));
        }
        orderRepository.saveAll(orders);
        Long orderCount = orderRepository.count();
        assertEquals(3, orderCount);
    }
}
