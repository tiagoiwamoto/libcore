package br.com.tiagoiwamoto.libcore.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public abstract class ResponseDto implements Serializable {

    private static final long serialVersionUID = 5313506058534154031L;

    protected String code;
    protected Object message;
    protected LocalDateTime timestamp;
}
