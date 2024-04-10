package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void populateTable() {
        userRepository.saveAll(Arrays.asList(
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
                ),
                new User(
                        "TomH1",
                        "Tom",
                        "Hanks",
                        "TomHanks@gmail.com",
                        "555666777"
                ))
        );
    }

    @Test
    public void usersInTable_GetUserWithGivenEmail_FetchedUserEqualToExpected() {
        User expectedUser = new User(
                1L,
                "SteveBlum1",
                "Steve",
                "Blum",
                "SteveBlum@gmail.com",
                "111222333"
        );
        Optional<User> retrievedUser = userRepository.findByEmail(expectedUser.getEmail());
        assertTrue(retrievedUser.isPresent());
        assertEquals(expectedUser, retrievedUser.get());
    }
}
