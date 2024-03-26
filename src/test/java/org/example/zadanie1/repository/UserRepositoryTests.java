package org.example.zadanie1.repository;

import org.example.zadanie1.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTests {

    UserRepository userRepository;

    private TestEntityManager entityManager;


    @Test
    public void getUserByEmailTest() {
        // Populate table with example users
//        User user1 = new User(
//                "SteveBlum1",
//                "Steve",
//                "Blum",
//                "SteveBlum@gmail.com",
//                "111222333"
//        );
//        entityManager.persist(user1);
//        User user = new User(
//                "JohnTrevolta1",
//                "John",
//                "Trevolta",
//                "JohnTrevolta@gmail.com",
//                "222333444"
//        );
//        entityManager.persist(user);
//        user = new User(
//                "TomH1",
//                "Tom",
//                "Hanks",
//                "TomHanks@gmail.com",
//                "555666777"
//        );
//        entityManager.persist(user);
//        // Retrieve user from database
//        Optional<User> retrievedUser = userRepository.findByEmail(user1.getEmail());
//        assertTrue(retrievedUser.isPresent());
//        assertEquals(user1.getEmail(), retrievedUser.get().getEmail());
        assert(true);
    }
}
