package local.example.aleatory.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AleatoryControllerTests {

    @Autowired
    private AleatoryController aleatoryController;

    @Test
    public void notNullResponseTest() {
        assertThat(aleatoryController).isNotNull();
    }
}
