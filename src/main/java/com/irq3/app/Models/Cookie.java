package com.irq3.app.Models;

import java.time.LocalDateTime;
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
        return uuid;
    }
}
