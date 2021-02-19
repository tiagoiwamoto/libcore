package com.tiagoiwamoto.iwtlibcore.model.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:07
 */

import com.tiagoiwamoto.iwtlibcore.util.UniqueUUID;

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

    public ApiDTO(String code, String message, T detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.protocol = new UniqueUUID().generate();
        this.timestamp = LocalDateTime.now();
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

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getDetail() {
        return detail;
    }

    public String getProtocol() {
        return protocol;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
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
