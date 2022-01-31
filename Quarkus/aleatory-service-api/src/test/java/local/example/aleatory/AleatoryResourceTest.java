package local.example.aleatory;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AleatoryResourceTest {

    @Test
    public void aleatoryEndpointTest() {
        given()
          .when().get("/aleatory")
          .then()
             .statusCode(200);
    }

    @Test
    public void rawEndpointTest() {
        given()
                .when().get("/raw")
                .then()
                .statusCode(200);
    }

    @Test
    public void vectorEndpointTest() {
        given()
                .when().get("/vector")
                .then()
                .statusCode(200);
    }
}
