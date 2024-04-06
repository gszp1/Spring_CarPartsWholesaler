package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.Order;
import org.example.zadanie1.model.OrderDetails;
import org.example.zadanie1.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void populateTables() {
        List<User> users = Arrays.asList(
                new User(
                        "SteveBlum1",
                        "Steve",
                        "Blum",
                        "SteveBlum@gmail.com",
                        "111222333"
                ),
                new User(
                        "JohnTrevolta1",
                        "John",
                        "Trevolta",
                        "JohnTrevolta@gmail.com",
                        "222333444"
                )
        );
        userRepository.saveAll(users);
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            orders.add(new Order(LocalDate.now(), LocalDate.now().plusDays(i), 1, users.get(1)));
        }
        orders.add(new Order(LocalDate.now(), LocalDate.now().plusDays(4), 1, users.getFirst()));
        orderRepository.saveAll(orders);
    }


    @AfterEach
    public void cleanTable() {
        orderRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void ordersInTable_CountOrders_ReturnsCorrectNumberOfOrders() {
        assertEquals(4L, orderRepository.count());
    }

    @Test
    public void ordersAndUsersInTables_CountOrdersByUser_ReturnsCorrectNumberOfOrders() {
        List<User> users = Arrays.asList(
                new User(
                        1L,
                        "SteveBlum1",
                        "Steve",
                        "Blum",
                        "SteveBlum@gmail.com",
                        "111222333"
                ),
                new User(
                        2L,
                        "JohnTrevolta1",
                        "John",
                        "Trevolta",
                        "JohnTrevolta@gmail.com",
                        "222333444"
                )
        );
        assertEquals(3, orderRepository.countByUser(users.get(1)));
        assertEquals(1, orderRepository.countByUser(users.get(0)));
    }
}
