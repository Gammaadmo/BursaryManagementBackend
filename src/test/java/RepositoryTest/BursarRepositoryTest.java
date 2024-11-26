package RepositoryTest;

import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;
import org.biic0.org.repository.BursarRepository;
import org.biic0.org.service.BursarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BursarRepositoryTest {

    @Mock
    private BursarRepository bursarRepository;  // Mock the repository

    @InjectMocks
    private BursarService bursarService;  // Inject the service which uses the repository

    private Bursar testBursar;
    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Set up test data
        testUser = new User.Builder()
                .setUserId("user123")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password")
                .setMobile("1234567890")
                .build();

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
        when(bursarRepository.save(testBursar)).thenReturn(testBursar);

        Bursar createdBursar = bursarService.create(testBursar);

        assertNotNull(createdBursar);
        assertEquals(testBursar.getBursarId(), createdBursar.getBursarId());
        verify(bursarRepository, times(1)).save(testBursar);
    }

    @Test
    public void testGetAllBursars() {
        when(bursarRepository.findAll()).thenReturn(List.of(testBursar));

        List<Bursar> bursars = bursarService.getAll();

        assertNotNull(bursars);
        assertFalse(bursars.isEmpty());
        assertEquals(1, bursars.size());
        verify(bursarRepository, times(1)).findAll();
    }

    @Test
    public void testGetBursarById() {
        when(bursarRepository.findById("bursar123")).thenReturn(Optional.of(testBursar));

        Bursar foundBursar = bursarService.read("bursar123");

        assertNotNull(foundBursar);
        assertEquals(testBursar.getBursarId(), foundBursar.getBursarId());
        verify(bursarRepository, times(1)).findById("bursar123");
    }

    @Test
    public void testUpdateBursar() {
        when(bursarRepository.existsById(testBursar.getBursarId())).thenReturn(true);
        when(bursarRepository.save(testBursar)).thenReturn(testBursar);

        Bursar updatedBursar = bursarService.update(testBursar);

        assertNotNull(updatedBursar);
        assertEquals(testBursar.getBursarId(), updatedBursar.getBursarId());
        verify(bursarRepository, times(1)).save(testBursar);
    }

    @Test
    public void testUpdateBursarNotFound() {
        when(bursarRepository.existsById(testBursar.getBursarId())).thenReturn(false);

        Bursar updatedBursar = bursarService.update(testBursar);

        assertNull(updatedBursar);
        verify(bursarRepository, times(0)).save(testBursar);
    }

    @Test
    public void testDeleteBursar() {
        when(bursarRepository.existsById("bursar123")).thenReturn(true);

        boolean isDeleted = bursarService.delete("bursar123");

        assertTrue(isDeleted);
        verify(bursarRepository, times(1)).deleteById("bursar123");
    }

    @Test
    public void testDeleteBursarNotFound() {
        when(bursarRepository.existsById("bursar123")).thenReturn(false);

        boolean isDeleted = bursarService.delete("bursar123");

        assertFalse(isDeleted);
        verify(bursarRepository, times(0)).deleteById("bursar123");
    }
}
