package com.irq3.app.Models;

import com.irq3.app.Cookies.Cookie;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;

public class RegisterAnnonucement extends Annonucement{
    Cookie cookie;
    public RegisterAnnonucement(String header, String description) {
        super(header, description);
        cookie = new Cookie();
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
