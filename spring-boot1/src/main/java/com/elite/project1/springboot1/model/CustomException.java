package com.elite.project1.springboot1.model;

import org.springframework.http.HttpStatus;

public class CustomException {
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public CustomException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private HttpStatus status;
    private String message;
}
