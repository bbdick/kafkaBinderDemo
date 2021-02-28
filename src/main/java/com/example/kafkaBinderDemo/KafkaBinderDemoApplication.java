package com.example.kafkaBinderDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MyOutputSource.class)
@SpringBootApplication
public class KafkaBinderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBinderDemoApplication.class, args);
	}
}
