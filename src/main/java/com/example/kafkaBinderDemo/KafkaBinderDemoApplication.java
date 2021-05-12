package com.example.kafkaBinderDemo;

import com.charter.scp.scl.api.commons.ApiServiceBase;
conimport com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.validation.Validator;
import java.util.function.Consumer;

//@SpringBootApplication
@Slf4j
public class KafkaBinderDemoApplication  extends ApiServiceBase {
	@Autowired
    private Validator validator;
	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {

		ctx = SpringApplication.run(KafkaBinderDemoApplication.class, args);
	}

    @Bean
	Consumer<ScpAuditMessage> testInput(final ObjectMapper mapper) {
        return (msg) -> {
            JsonNode jsonNode = mapper.valueToTree(msg);
            log.info("consumeListener received {} ", jsonNode);
        };
    }

}
