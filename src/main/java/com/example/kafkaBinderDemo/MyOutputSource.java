package com.example.kafkaBinderDemo;

import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

public interface MyOutputSource {
    public final static String CHANNEL = "testOutput";

    @Output(CHANNEL)
    MessageChannel testOutput();
}