package com.irq3.app.Models;

import jakarta.servlet.http.HttpSession;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RegisterAnnonucement extends Annonucement{
    String session;
    public RegisterAnnonucement(String header, String description, HttpSession session) {
        super(header, description);
        this.session = session.getId();
    }
    public RegisterAnnonucement(String header, String description)
    {
        super(header,description);
    }


    @Override
    public String toString() {
        return "RegisterAnnonucement{" +
                "header='" + this.getHeader() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", date=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(this.getDate()) +
                "cookie=" + this. session+
                '}';
    }
}
