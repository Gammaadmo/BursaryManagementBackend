package FactoryTest;

import org.biic0.org.domain.Bursar;
import org.biic0.org.factory.BursarFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BursarFactoryTest {

    private BursarFactory bursarFactory;

    @BeforeEach
    public void setUp() {
        bursarFactory = new BursarFactory();  // Initialize the BursarFactory before each test
    }

    @Test
    public void testCreateBursar() {
        // Creating test data for bursar creation
        String bursarID = "B123";
        String name = "John Doe";
        String department = "Finance";

        // Using the factory to create a Bursar instance
        Bursar bursar = bursarFactory.createBursar(bursarID, name, department);

        // Assertions to verify the Bursar instance
        assertNotNull(bursar, "Bursar should not be null");
        assertEquals(bursarID, bursar.getBursarID(), "Bursar ID should match");
        assertEquals(name, bursar.getName(), "Name should match");
        assertEquals(department, bursar.getDepartment(), "Department should match");
    }

    @Test
    public void testCreateBursarWithEmptyValues() {
        // Creating test data with empty values
        String bursarID = "";
        String name = "";
        String department = "";

        // Using the factory to create a Bursar instance
        Bursar bursar = bursarFactory.createBursar(bursarID, name, department);

        // Assertions to verify the Bursar instance
        assertNotNull(bursar, "Bursar should not be null even with empty values");
        assertEquals(bursarID, bursar.getBursarID(), "Bursar ID should match");
        assertEquals(name, bursar.getName(), "Name should match");
        assertEquals(department, bursar.getDepartment(), "Department should match");
    }
}
