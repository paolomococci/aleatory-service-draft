package local.example.aleatory.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AleatoryVectorControllerMockMvcTests {

    private static final String PATH = "/vector";

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webAppCtx;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppCtx).build();
    }

    @Test
    public void testRestControllerStatusIsOk()
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(status().isOk());
    }
}
