package com.irq3.app.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Annonucement {
    private String header, description;
    private LocalDate date;

    public Annonucement(String header, String description) {
        this.header = header;
        this.description = description;
        this.date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Annonucement{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", date=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date) +
                '}';
    }
}
