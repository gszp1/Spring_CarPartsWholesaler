package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.Order;
import org.example.zadanie1.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void cleanTable() {
        orderRepository.deleteAll();
        userRepository.deleteAll();
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

    @Test
    public void getOrdersCountByUserEmailTest() {
        // Add users
        User user1 = new User(
                "SteveBlum1",
                "Steve",
                "Blum",
                "SteveBlum@gmail.com",
                "111222333"
        );
        userRepository.save(user1);
        User user = new User(
                "JohnTrevolta1",
                "John",
                "Trevolta",
                "JohnTrevolta@gmail.com",
                "222333444"
        );
        userRepository.save(user);
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            orders.add(new Order(LocalDate.now(), LocalDate.now().plusDays(i), 1, user1));
        }
        orders.add(new Order(LocalDate.now(), LocalDate.now().plusDays(4), 1, user));
        orderRepository.saveAll(orders);
        assertEquals(3, orderRepository.countByUserEmail(user1.getEmail()));
        assertEquals(1, orderRepository.countByUserEmail(user.getEmail()));
    }

}
