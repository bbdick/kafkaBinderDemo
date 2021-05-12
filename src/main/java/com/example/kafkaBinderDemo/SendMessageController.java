package com.example.kafkaBinderDemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class SendMessageController {

//    private MyOutputSource kafkaSource;
    private org.springframework.context.ApplicationContext ctx;

    @GetMapping("send")
    public ResponseEntity sendMessage(@RequestParam final String message) {
        final MessageBuilder<MessagePayload> builder = MessageBuilder.withPayload(MessagePayload.builder().message(message).build());
//        kafkaSource.testOutput().send(builder.build());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("stop")
    public ResponseEntity stopApplication() {
        int exitCode = SpringApplication.exit(ctx, () -> 0);
		System.exit(exitCode);
		return ResponseEntity.ok().build();
    }

    @Builder
    @Data
    static class MessagePayload {
        private String message;
    }


}
