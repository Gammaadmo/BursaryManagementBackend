package ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.biic0.org.controller.BursarController;
import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;
import org.biic0.org.service.IBursarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BursarControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IBursarService bursarService;

    @InjectMocks
    private BursarController bursarController;

    private User someUserObject;
    // Create a dummy Bursar object using the builder pattern
    Bursar bursar = new Bursar.Builder()
            .setBursarID("B001")
            .setName("John Doe")
            .setRegistrationNumber("12345")
            .setDepartment("Finance")
            .setUser(someUserObject) // Make sure you pass a User object here
            .build();


    @BeforeEach
    void setUp() {
        // Set up the MockMvc instance
        mockMvc = MockMvcBuilders.standaloneSetup(bursarController).build();

    }

    @Test
    void testCreateBursar() throws Exception {
        // Mocking the service method call
        when(bursarService.create(any(Bursar.class))).thenReturn(bursar);

        // Performing POST request to create a bursar
        mockMvc.perform(post("/api/bursars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bursar)))
                .andExpect(status().isCreated()) // Expect HTTP status 201 (Created)
                .andExpect(jsonPath("$.bursarID").value("B001"))
                .andExpect(jsonPath("$.name").value("Test Bursar"))
                .andExpect(jsonPath("$.email").value("test@bursar.com"));

        // Verifying that the service method was called once
        verify(bursarService, times(1)).create(any(Bursar.class));
    }

    @Test
    void testGetAllBursars() throws Exception {
        // Mocking the service method to return a list of bursars
        when(bursarService.getAll()).thenReturn(List.of(bursar));

        // Performing GET request to retrieve all bursars
        mockMvc.perform(get("/api/bursars"))
                .andExpect(status().isOk()) // Expect HTTP status 200 (OK)
                .andExpect(jsonPath("$[0].bursarID").value("B001"))
                .andExpect(jsonPath("$[0].name").value("Test Bursar"))
                .andExpect(jsonPath("$[0].email").value("test@bursar.com"));

        // Verifying that the service method was called once
        verify(bursarService, times(1)).getAll();
    }

    @Test
    void testGetBursarById() throws Exception {
        // Mocking the service method to return a bursar by ID
        when(bursarService.read("B001")).thenReturn(bursar);

        // Performing GET request to retrieve a specific bursar by ID
        mockMvc.perform(get("/api/bursars/B001"))
                .andExpect(status().isOk()) // Expect HTTP status 200 (OK)
                .andExpect(jsonPath("$.bursarID").value("B001"))
                .andExpect(jsonPath("$.name").value("Test Bursar"))
                .andExpect(jsonPath("$.email").value("test@bursar.com"));

        // Verifying that the service method was called once
        verify(bursarService, times(1)).read("B001");
    }

    @Test
    void testUpdateBursar() throws Exception {
        // Mocking the service method to return the updated bursar
        when(bursarService.update(any(Bursar.class))).thenReturn(bursar);

        // Performing PUT request to update a bursar
        mockMvc.perform(put("/api/bursars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bursar)))
                .andExpect(status().isOk()) // Expect HTTP status 200 (OK)
                .andExpect(jsonPath("$.bursarID").value("B001"))
                .andExpect(jsonPath("$.name").value("Test Bursar"))
                .andExpect(jsonPath("$.email").value("test@bursar.com"));

        // Verifying that the service method was called once
        verify(bursarService, times(1)).update(any(Bursar.class));
    }

    @Test
    void testDeleteBursar() throws Exception {
        // Mocking the service method to return true on successful delete
        when(bursarService.delete("B001")).thenReturn(true);

        // Performing DELETE request to delete a bursar
        mockMvc.perform(delete("/api/bursars/B001"))
                .andExpect(status().isNoContent()); // Expect HTTP status 204 (No Content)

        // Verifying that the service method was called once
        verify(bursarService, times(1)).delete("B001");
    }
}
