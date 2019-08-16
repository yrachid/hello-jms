package com.example.hello.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TweetSubscriber {

    private final List<Tweet> tweets = new ArrayList<>();

    public List<Tweet> getTweets() {
        return tweets;
    }

    @JmsListener(destination = "mailingQ", containerFactory = "myFactory")
    public void receiveMessage(Tweet tweet) {
        System.out.println("Received <" + tweet + ">");
        tweets.add(tweet);
    }
}
