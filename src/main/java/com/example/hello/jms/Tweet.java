package com.example.hello.jms;

public class Tweet {

    private String user;
    private String message;

    public Tweet() {
    }

    public Tweet(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Tweet{" +
            "user='" + user + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
