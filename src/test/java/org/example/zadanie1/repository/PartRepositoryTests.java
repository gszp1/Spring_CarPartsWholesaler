package org.example.zadanie1.repository;

import org.example.zadanie1.model.Part;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class PartRepositoryTests {

    PartRepository partRepository;

    private TestEntityManager entityManager;

    @Test
    public void getPartsByPriceRangeTest() {
        // Given:
        // When:

        // Then:

    }


}
