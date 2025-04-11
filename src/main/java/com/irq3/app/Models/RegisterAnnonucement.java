package com.irq3.app.Models;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;

public class RegisterAnnonucement extends Annonucement{
    Cookie cookie;
    public RegisterAnnonucement(String header, String description, Cookie cookie) {
        super(header, description);
        this.cookie = cookie;
    }
    public RegisterAnnonucement(String header, String description)
    {
        super(header,description);
    }
    public UUID getUUID()
    {
        return cookie.getUuid();
    }

    @Override
    public String toString() {
        return "RegisterAnnonucement{" +
                "header='" + this.getHeader() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", date=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(this.getDate()) +
                "cookie=" + this.getUUID() +
                '}';
    }
}
