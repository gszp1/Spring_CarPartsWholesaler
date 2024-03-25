package org.example.zadanie1.repository;

import org.example.zadanie1.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTests {

    UserRepository userRepository;

    TestEntityManager entityManager;

    @Test
    public void getUserByEmailTest() {
        // Given:
        User user = new User(
                "SteveBlum1",
                "Steve",
                "Blum",
                "SteveBlum@gmail.com",
                "111222333"
        );
        User savedUser = userRepository.save(user);
        // When:

        // Then:
    }
}
