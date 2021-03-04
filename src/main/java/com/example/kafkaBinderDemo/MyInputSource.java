package com.example.kafkaBinderDemo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MyInputSource {
    public final static String CHANNEL = "testInput";

    @Input(CHANNEL)
    MessageChannel testInput();
}