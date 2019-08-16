package functional;

import org.junit.Test;
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
public class TweetPublishingTest {

    @LocalServerPort
    private int port;

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan("com.example.hello.jms")
    public static class TestConfig {
    }

    @Test
    public void it_runs() {
        System.out.println("It does nothing besides proving that Spring test config works.");
    }
}
