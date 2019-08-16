package com.example.hello.jms;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TweetPublishingControllerTest {

    @Mock
    private JmsTemplate template;
    private TweetPublishingController controller;

    @Before
    public void setUp() {
        controller = new TweetPublishingController(
            template,
            new TweetSubscriber()
        );
    }

    @Test
    public void publishes_tweet_to_mailing_queue() {
        controller.postMessage("abc", "hello");

        verify(template).convertAndSend("mailingQ", new Tweet("abc", "hello"));
    }
}