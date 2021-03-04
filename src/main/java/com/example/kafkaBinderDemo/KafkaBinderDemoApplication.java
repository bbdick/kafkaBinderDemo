package com.example.kafkaBinderDemo;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding({MyOutputSource.class, MyInputSource.class})
@SpringBootApplication
@Slf4j
public class KafkaBinderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBinderDemoApplication.class, args);
	}

	@StreamListener(MyInputSource.CHANNEL)
	public void consume(final JsonNode message) {
		log.info("received {}", message);
	}
}
