package org.example.zadanie1.repository;

import jakarta.transaction.Transactional;
import org.example.zadanie1.model.Part;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class PartRepositoryTests {

    @Autowired
    private PartRepository partRepository;

    @AfterEach
    public void cleanTable() {
        partRepository.deleteAll();
    }

    @Test
    public void getPartsByPriceRangeTest() {
        // Insert into database example parts
        List<Part> parts = new ArrayList<>();
        parts.add(new Part("Oil Filter", new BigDecimal("22.5"), 10L));
        parts.add(new Part("Air Filter", new BigDecimal("10.5"), 40L));
        parts.add(new Part("Seat", new BigDecimal("100.25"), 5L));
        partRepository.saveAll(parts);

        // Retrieve parts and check if their prices are in given boundaries
        BigDecimal leftBoundary = new BigDecimal("10");
        BigDecimal rightBoundary = new BigDecimal("30");
        List<Part> retrievedParts = partRepository
                .findByUnitPriceBetween(leftBoundary, rightBoundary);
        assertEquals(2, retrievedParts.size());
        retrievedParts.forEach(part -> assertTrue((part.getUnitPrice().compareTo(leftBoundary) >= 0)
                && (part.getUnitPrice().compareTo(rightBoundary) <= 0)));
    }
}
