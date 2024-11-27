package ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.biic0.org.controller.BursaryController;
import org.biic0.org.domain.Bursary;
import org.biic0.org.service.IBursaryService;
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

public class BursaryControllerTests {

    private MockMvc mockMvc;

    @Mock
    private IBursaryService bursaryService;

    @InjectMocks
    private BursaryController bursaryController;

    private Bursary bursary;

    @BeforeEach
    void setUp() {
        // Set up the MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(bursaryController).build();

        // Create a dummy Bursary object for testing
        bursary = new Bursary();
        bursary.setId(1L);
        bursary.setBursaryId("B001");
        bursary.setName("Test Bursary");
    }

    @Test
    void testCreateBursary() throws Exception {
        when(bursaryService.create(any(Bursary.class))).thenReturn(bursary);

        mockMvc.perform(post("/api/bursaries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bursary)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.bursaryId").value("B001"))
                .andExpect(jsonPath("$.name").value("Test Bursary"));

        verify(bursaryService, times(1)).create(any(Bursary.class));
    }

    @Test
    void testGetAllBursaries() throws Exception {
        when(bursaryService.getAll()).thenReturn(List.of(bursary));

        mockMvc.perform(get("/api/bursaries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].bursaryId").value("B001"))
                .andExpect(jsonPath("$[0].name").value("Test Bursary"));

        verify(bursaryService, times(1)).getAll();
    }
}
