package com.irq3.app.Models;

import jakarta.servlet.http.HttpSession;

import java.util.UUID;

public class DTOMessage {
    String header;
    String description;
    String cookie;
    public DTOMessage(String header, String description, String cookie) {
        this.header = header;
        this.description = description;
        this.cookie = cookie;
    }
    public Message build(HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        return new Message(this.header, this.description, user);
    }
}
