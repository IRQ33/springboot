package com.irq3.app.Models;

public class FastError {
    private String error;

    public FastError(String error) {
        this.error = error;
    }

    public FastError() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "FastError{" +
                "error='" + error + '\'' +
                '}';
    }
}
