package com.irq3.app.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String header;
    String description;
    @ManyToOne
    User author;
    LocalDateTime time;

    public Message() {
        this.time = LocalDateTime.now();
    }
    public Message(String header, String description, User author) {
        this.header = header;
        this.description = description;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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
                ", user=" + author +
                ", time=" + time +
                '}';
    }
}
