package com.example.hello.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetPublishingController {

    private JmsTemplate template;

    private TweetSubscriber subscriber;

    public TweetPublishingController(JmsTemplate template, TweetSubscriber subscriber) {
        this.template = template;
        this.subscriber = subscriber;
    }

    @PostMapping("/tweet/{user}/{body}")
    public String postMessage(@PathVariable String user, @PathVariable String body) {
        template.convertAndSend(
            "mailingQ",
            new Tweet(user, body)
        );

        return "OK";
    }

    @GetMapping("/tweets")
    public List<Tweet> getTweets() {
        return subscriber.getTweets();
    }
}
