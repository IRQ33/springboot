package com.irq3.app.Models;

import com.irq3.app.Cookies.CookieManager;

import java.time.LocalDateTime;

public class DTOMessage {
    String header;
    String description;
    Cookie cookie;
    public DTOMessage(String header, String description, Cookie cookie) {
        this.header = header;
        this.description = description;
        this.cookie = cookie;
    }
    public Message build(CookieManager manager)
    {
        User user =manager.getUser(this.cookie);
        return new Message(this.header, this.description, user);
    }
}
