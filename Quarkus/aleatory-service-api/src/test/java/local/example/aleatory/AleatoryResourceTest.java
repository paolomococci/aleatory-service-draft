package local.example.aleatory;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
    public void vectorOfLongEndpointTest() {
        given()
                .when().get("/vector-long")
                .then()
                .statusCode(200);
    }

    @Test
    public void vectorOfDoubleEndpointTest() {
        given()
                .when().get("/vector-double")
                .then()
                .statusCode(200);
    }
}
