package com.example.kafkaBinderDemo;

import com.charter.scp.scl.api.commons.ApiServiceBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.Valid;
import javax.validation.Validator;
import java.time.Instant;

@EnableBinding({MyOutputSource.class, MyInputSource.class})
//@SpringBootApplication
@Slf4j
public class KafkaBinderDemoApplication extends ApiServiceBase {
	@Autowired
    private Validator validator;
	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {

		ctx = SpringApplication.run(KafkaBinderDemoApplication.class, args);
	}

	@StreamListener(MyInputSource.CHANNEL)
	public void consume(@Valid final ScpAuditMessage message) {
		log.info("received {}", message);
		if (message.getTimestamp().isBefore(Instant.now())) {
			throw new IllegalArgumentException("time is in the past");
		}
	}

//	@StreamListener(MyInputSource.CHANNEL)
//	public void consume(final ScpAuditMessage message) {
//		log.info("received {}", message);
//		Set<ConstraintViolation<ScpAuditMessage>> violations = validator.validate(message);
//		if (!violations.isEmpty()) {
//			throw new ConstraintViolationException(violations);
//		}
//	}

}
