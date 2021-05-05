/*
 * Copyright 2020, Charter Communications, All rights reserved.
 */
package com.example.kafkaBinderDemo;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * POJO for SCP service audit kafka message, which is externally facing for PI clients.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class ScpAuditMessage {

    @NotNull
    private Instant timestamp;

    @NotNull
    private JsonNode audit;
}
