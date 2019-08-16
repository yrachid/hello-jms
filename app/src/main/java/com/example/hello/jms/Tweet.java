package com.example.hello.jms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tweet {

    private String user;
    private String message;
}
