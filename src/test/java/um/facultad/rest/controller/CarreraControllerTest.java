package um.facultad.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import um.facultad.rest.service.CarreraService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarreraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CarreraService carreraService;

    @Test
    @WithMockUser
    public void testFindAll() throws Exception {
        mockMvc.perform(get("/carrera/")).andExpect(status().isOk());
    }
}
