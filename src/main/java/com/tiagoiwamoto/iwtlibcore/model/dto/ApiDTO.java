package com.tiagoiwamoto.iwtlibcore.model.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:07
 */

import java.io.Serializable;
import java.time.LocalDateTime;

public class ApiDTO<T> implements Serializable {

    private static final long serialVersionUID = -3834803335741634479L;

    private String code;
    private String message;
    private T detail;
    private String protocol;
    private LocalDateTime timestamp;

    public ApiDTO() { }

    public ApiDTO(String code, String message, T detail, String protocol, LocalDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.protocol = protocol;
        this.timestamp = timestamp;
    }

    public static ApiDTO anApiDTO() {
        return new ApiDTO();
    }

    public ApiDTO withCode(String code) {
        this.code = code;
        return this;
    }

    public ApiDTO withMessage(String message) {
        this.message = message;
        return this;
    }

    public ApiDTO withDetail(T detail) {
        this.detail = detail;
        return this;
    }

    public ApiDTO withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public ApiDTO withTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiDTO{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", detail=").append(detail);
        sb.append(", protocol='").append(protocol).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
