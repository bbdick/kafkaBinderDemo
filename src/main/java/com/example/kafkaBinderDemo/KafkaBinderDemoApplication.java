package com.example.kafkaBinderDemo;

import com.charter.scp.scl.api.commons.ApiServiceBase;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ConfigurableApplicationContext;

@EnableBinding({MyOutputSource.class, MyInputSource.class})
//@SpringBootApplication
@Slf4j
public class KafkaBinderDemoApplication extends ApiServiceBase {
	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {

		ctx = SpringApplication.run(KafkaBinderDemoApplication.class, args);
	}

	@StreamListener(MyInputSource.CHANNEL)
	public void consume(final JsonNode message) {
		log.info("received {}", message);
	}

}
