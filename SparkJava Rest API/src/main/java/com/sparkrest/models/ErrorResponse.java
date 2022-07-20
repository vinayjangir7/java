package com.sparkrest.models;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timeStamp; // - a timestamp of the error occurred
    private String title; // – a brief, human-readable message about the error
    private int status; // – the HTTP response code (optional)
    private  String detail; // – a human-readable explanation of the error

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
