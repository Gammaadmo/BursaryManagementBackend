package FactoryTest;

import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;
import org.biic0.org.factory.BursarFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BursarFactoryTest {

    private BursarFactory bursarFactory;
    private User mockUser;

    @BeforeEach
    void setUp() {
        // Initialize the BursarFactory and mock User before each test
        bursarFactory = new BursarFactory();
        mockUser = mock(User.class); // Mocking the User object since it's part of the Bursar
    }

    @Test
    void testCreateBursar() {
        // Create a Bursar object using the factory
        Bursar bursar = bursarFactory.createBursar("B001", "Test Bursar", "REG12345",
                "1234567890", "test@bursar.com", mockUser);

        // Assert that the Bursar object has the expected properties
        assertNotNull(bursar);
        assertEquals("B001", bursar.getBursarId());
        assertEquals("Test Bursar", bursar.getName());
        assertEquals("REG12345", bursar.getRegistrationNumber());
        assertEquals("1234567890", bursar.getContactNumber());
        assertEquals("test@bursar.com", bursar.getEmailAddress());
        assertEquals(mockUser, bursar.getUser());
    }

    @Test
    void testCreateDefaultBursar() {
        // Create a default Bursar object using the factory
        Bursar bursar = bursarFactory.createDefaultBursar(mockUser);

        // Assert that the default Bursar object is created with expected default values
        assertNotNull(bursar);
        assertNotNull(bursar.getBursarId());
        assertEquals("Default Name", bursar.getName());
        assertEquals("Default Reg Number", bursar.getRegistrationNumber());
        assertEquals("0000000000", bursar.getContactNumber());
        assertEquals("default@example.com", bursar.getEmailAddress());
        assertEquals(mockUser, bursar.getUser());
    }

    @Test
    void testGenerateBursarIdIsUnique() {
        // Create two Bursar objects to check for unique BursarId
        Bursar bursar1 = bursarFactory.createDefaultBursar(mockUser);
        Bursar bursar2 = bursarFactory.createDefaultBursar(mockUser);

        // Assert that both bursar objects have unique IDs
        assertNotEquals(bursar1.getBursarId(), bursar2.getBursarId());
    }
}
