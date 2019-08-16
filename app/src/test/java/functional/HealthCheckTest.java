package functional;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class HealthCheckTest extends BaseFunctionalTest {

    @Test
    public void responds_with_plain_text_ok_message() {
        given(theContextToCommunicateToTheApplication())
            .when()
            .get("/health")
            .then()
            .statusCode(200)
            .and()
            .body(is("OK"));
    }
}
