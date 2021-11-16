package com.calculator.vbaisa.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class Error {
    private final HttpStatus status;
    private final String errorCode;
    private final String message;
    private final String detail;
    private final String path;
    @JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss a")
    private final LocalDateTime timeStamp;

    private Error(Builder builder) {
        this.status = builder.status;
        this.errorCode = builder.errorCode;
        this.message = builder.message;
        this.detail = builder.detail;
        this.path = builder.path;
        this.timeStamp = builder.timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        if(status != null && !status.toString().isBlank()) buffer.append("status: " + status).append(System.lineSeparator());
        if(errorCode != null && !errorCode.isBlank()) buffer.append("errorCode: " + errorCode).append(System.lineSeparator());
        if(message != null && !message.isBlank()) buffer.append("message: ").append(message).append(System.lineSeparator());
        if(detail != null && !detail.isBlank()) buffer.append("detail: " + detail).append(System.lineSeparator());
        if(path != null && !path.isBlank()) buffer.append("path: " + path).append(System.lineSeparator());
        if(timeStamp != null && !timeStamp.toString().isBlank()) buffer.append("timeStamp: " + timeStamp).append(System.lineSeparator());

        return buffer.toString();
    }
    @Component
    public static class Builder {
        private HttpStatus status;
        private String errorCode;
        private String message;
        private String detail;
        private String path;
        @JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss a")
        private LocalDateTime timeStamp;

        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setTimeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Error build() {
            return new Error(this);
        }
    }
}
