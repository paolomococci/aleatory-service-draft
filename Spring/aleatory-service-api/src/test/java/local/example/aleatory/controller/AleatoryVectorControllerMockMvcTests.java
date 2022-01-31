package local.example.aleatory.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AleatoryVectorControllerMockMvcTests {

    private static final String PATH = "/vector";

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testRestControllerStatusIsOk()
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(status().isOk());
    }

    @Test
    public void testRestControllerContentType()
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void testRestControllerIsArray()
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testRestControllerValueType()
            throws Exception {
        for (int i = 0; i < 256; i++) {
            String temp = "$[" + i + "]";
            mockMvc.perform(get(PATH))
                    .andExpect(jsonPath(temp).isNumber());
        }
    }
}
