package com.irq3.app.Cookies;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.UUID;

public class Cookie {
    private LocalDateTime time;
    private UUID uuid;

    public Cookie() {
        time = LocalDateTime.now();
        uuid = UUID.randomUUID();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public UUID getUuid() {
        if (time.plusMinutes(10).isBefore(LocalDateTime.now()))
        {
            throw new RuntimeException("issue");
        }
        return uuid;
    }
}
