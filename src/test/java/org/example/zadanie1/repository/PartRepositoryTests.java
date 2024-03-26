package org.example.zadanie1.repository;

import org.example.zadanie1.model.Part;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PartRepositoryTests {

    @Autowired
    private PartRepository partRepository;

    @Test
    public void getPartsByPriceRangeTest() {



    }


}
