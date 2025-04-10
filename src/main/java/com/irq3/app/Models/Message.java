package com.irq3.app.Models;

import java.time.LocalDateTime;

public class Message {
    String header;
    String description;
    User user;
    LocalDateTime time;

    public Message() {
        this.time = LocalDateTime.now();
    }

    public Message(String header, String description, User user) {
        this.header = header;
        this.description = description;
        this.user = user;
        this.time = LocalDateTime.now();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", time=" + time +
                '}';
    }
}
