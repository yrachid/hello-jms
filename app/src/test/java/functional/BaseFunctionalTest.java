package functional;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TweetPublishingTest.TestConfig.class)
public abstract class BaseFunctionalTest {

    @LocalServerPort
    protected int port;

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan({"com.example.hello.jms", "functional"})
    public static class TestConfig {
    }

    protected RequestSpecification theContextToCommunicateToTheApplication() {

        return new RequestSpecBuilder()
            .setPort(port)
            .setAccept(ContentType.JSON)
            .build();

    }

}
