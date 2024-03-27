package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void cleanTable() {
        userRepository.deleteAll();
    }

    @Test
    public void getUserByEmailTest() {
        // Populate table with example users
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
        user = new User(
                "TomH1",
                "Tom",
                "Hanks",
                "TomHanks@gmail.com",
                "555666777"
        );
        userRepository.save(user);
        // Retrieve user from database
        Optional<User> retrievedUser = userRepository.findByEmail(user1.getEmail());
        assertTrue(retrievedUser.isPresent());
        assertEquals(user1.getEmail(), retrievedUser.get().getEmail());
    }
}
