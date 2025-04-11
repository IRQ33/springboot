package com.irq3.app.Models;

import com.irq3.app.Cookies.CookieManager;

import java.time.LocalDateTime;
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
    public Message build(CookieManager manager)
    {
        UUID uuid = UUID.fromString(cookie);
        System.out.println(uuid.toString());
        User user = manager.getUser(uuid);
        System.out.println(user.toString());
        return new Message(this.header, this.description, user);
    }
}
