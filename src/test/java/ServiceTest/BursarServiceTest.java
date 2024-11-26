package ServiceTest;

import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;
import org.biic0.org.repository.BursarRepository;
import org.biic0.org.service.BursarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BursarServiceTest {

    @Mock
    private BursarRepository bursarRepository;

    @InjectMocks
    private BursarService bursarService;

    private Bursar testBursar;
    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a test User
        testUser = new User.Builder()
                .setUserId("user123")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password")
                .setMobile("1234567890")
                .build();

        // Create a test Bursar
        testBursar = new Bursar.Builder()
                .setBursarId("bursar123")
                .setName("Bursar One")
                .setRegistrationNumber("123456")
                .setContactNumber("9876543210")
                .setEmailAddress("bursar.one@example.com")
                .setUser(testUser)
                .build();
    }

    @Test
    public void testCreateBursar() {
        // Mock the repository save method
        when(bursarRepository.save(testBursar)).thenReturn(testBursar);

        // Call the service method
        Bursar createdBursar = bursarService.create(testBursar);

        // Verify the result
        assertNotNull(createdBursar);
        assertEquals(testBursar.getBursarId(), createdBursar.getBursarId());
        verify(bursarRepository, times(1)).save(testBursar);
    }

    @Test
    public void testGetAllBursars() {
        // Mock the repository findAll method
        when(bursarRepository.findAll()).thenReturn(List.of(testBursar));

        // Call the service method
        List<Bursar> bursars = bursarService.getAll();

        // Verify the result
        assertNotNull(bursars);
        assertFalse(bursars.isEmpty());
        assertEquals(1, bursars.size());
        verify(bursarRepository, times(1)).findAll();
    }

    @Test
    public void testGetBursarById() {
        // Mock the repository findById method
        when(bursarRepository.findById("bursar123")).thenReturn(Optional.of(testBursar));

        // Call the service method
        Bursar foundBursar = bursarService.read("bursar123");

        // Verify the result
        assertNotNull(foundBursar);
        assertEquals(testBursar.getBursarId(), foundBursar.getBursarId());
        verify(bursarRepository, times(1)).findById("bursar123");
    }

    @Test
    public void testUpdateBursar() {
        // Mock the repository methods
        when(bursarRepository.existsById(testBursar.getBursarId())).thenReturn(true);
        when(bursarRepository.save(testBursar)).thenReturn(testBursar);

        // Call the service method
        Bursar updatedBursar = bursarService.update(testBursar);

        // Verify the result
        assertNotNull(updatedBursar);
        assertEquals(testBursar.getBursarId(), updatedBursar.getBursarId());
        verify(bursarRepository, times(1)).save(testBursar);
    }

    @Test
    public void testUpdateBursarNotFound() {
        // Mock the repository existsById method to return false
        when(bursarRepository.existsById(testBursar.getBursarId())).thenReturn(false);

        // Call the service method
        Bursar updatedBursar = bursarService.update(testBursar);

        // Verify the result
        assertNull(updatedBursar);
        verify(bursarRepository, times(0)).save(testBursar);
    }

    @Test
    public void testDeleteBursar() {
        // Mock the repository existsById method
        when(bursarRepository.existsById("bursar123")).thenReturn(true);

        // Call the service method
        boolean isDeleted = bursarService.delete("bursar123");

        // Verify the result
        assertTrue(isDeleted);
        verify(bursarRepository, times(1)).deleteById("bursar123");
    }

    @Test
    public void testDeleteBursarNotFound() {
        // Mock the repository existsById method to return false
        when(bursarRepository.existsById("bursar123")).thenReturn(false);

        // Call the service method
        boolean isDeleted = bursarService.delete("bursar123");

        // Verify the result
        assertFalse(isDeleted);
        verify(bursarRepository, times(0)).deleteById("bursar123");
    }
}
