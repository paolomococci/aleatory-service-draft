package local.example.aleatory.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AleatoryControllerMockMvcTests {

    private static final String PATH = "/";
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webAppCtx;

    @Test
    void sampleTest() {
    }
}
