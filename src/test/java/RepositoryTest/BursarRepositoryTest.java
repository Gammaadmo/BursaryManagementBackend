package RepositoryTest;

import org.biic0.org.domain.Bursar;
import org.biic0.org.repository.BursarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BursarRepositoryTest {

    @Autowired
    public BursarRepository bursarRepository;

    private Bursar bursar;

    @BeforeEach
    public void setUp() {
        bursar = new Bursar("123", "John Doe", "Finance");
        bursarRepository.save(bursar);
    }

    @Test
    public void testSaveBursar() {
        assertNotNull(bursarRepository.findById(bursar.getBursarID()).orElse(null));
    }

    @Test
    public void testFindBursarById() {
        Bursar foundBursar = bursarRepository.findById(bursar.getBursarID()).orElse(null);
        assertNotNull(foundBursar);
    }
}
