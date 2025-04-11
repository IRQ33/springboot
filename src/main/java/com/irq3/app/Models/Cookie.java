package com.irq3.app.Models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Cookie {
    private final LocalDateTime time;
    private final UUID uuid;

    public Cookie() {
        time = LocalDateTime.now();
        uuid = UUID.randomUUID();
    }

    public Cookie(UUID uuid) {
        this.uuid = uuid;
        this.time = LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return Objects.equals(uuid, cookie.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}