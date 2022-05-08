package br.com.tiagoiwamoto.libcore.model.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:07
 */

import br.com.tiagoiwamoto.libcore.util.UniqueUUID;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Its a simple DTO with automatic protocol and timestamp.
 * Follow the jsonapi model
 * @param <T> specified the object you want to use here.
 */
@Getter
@ToString
public class SuccessResponseDto<T> extends ResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3834803335741634479L;

    private T data;
    private String protocol;

    public SuccessResponseDto of(String code, String message, T data) {
        return new SuccessResponseDto(code, message, data);
    }

    private SuccessResponseDto(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.protocol = new UniqueUUID().generate();
        this.timestamp = LocalDateTime.now();
    }
}
