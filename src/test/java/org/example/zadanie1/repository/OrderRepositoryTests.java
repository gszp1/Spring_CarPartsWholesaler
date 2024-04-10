package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.Order;
import org.example.zadanie1.model.OrderDetails;
import org.example.zadanie1.model.Part;
import org.example.zadanie1.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

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
        Part part = new Part("Oil Filter", new BigDecimal("22.5"), 10L);
        Order order = new Order(LocalDate.now(), LocalDate.now().plusDays(3), 1, users.get(1));
        OrderDetails orderDetails = new OrderDetails(part, order, 1L, part.getUnitPrice());
        part.getOrderDetails().add(orderDetails);
        order.getOrderDetails().add(orderDetails);
        partRepository.save(part);
        orders.add(order);
        orderRepository.saveAll(orders);
        orderDetailsRepository.save(orderDetails);

    }

    @Test
    public void ordersInTable_CountOrders_ReturnsCorrectNumberOfOrders() {
        Long count = orderRepository.count();
        assertEquals(5L, count);
        System.out.println(count);
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
        Long count = orderRepository.countByUser(users.get(1));
        assertEquals(4, count);
        System.out.println(count);
        assertEquals(1, count = orderRepository.countByUser(users.getFirst()));
        System.out.println(count);
    }

    @Test
    public void orderedProductExists_CountOrderedProductWithGivenName_ReturnsCorrectNumberOfOrderedProducts() {
        Long count = orderRepository.countByOrderDetailsPartName("Oil Filter");
        assertEquals(1L, count);
        System.out.println(count);
    }
}
