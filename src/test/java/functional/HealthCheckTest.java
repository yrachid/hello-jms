package functional;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = HealthCheckTest.TestConfig.class)
public class HealthCheckTest {

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan("com.example.hello.jms")
    public static class TestConfig {
    }

    @LocalServerPort
    private int port;

    @Test
    public void responds_with_plain_text_ok_message() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
            .setPort(port)
            .setAccept(ContentType.JSON)
            .build();

        RestAssured
            .given(requestSpec)
            .when()
            .get("/health")
            .then()
            .statusCode(200)
            .and()
            .body(is("OK"));
    }
}
