package br.com.tiagoiwamoto.libcore.model.dto;

import br.com.tiagoiwamoto.libcore.util.UniqueUUID;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorResponseDto extends ResponseDto implements Serializable {

    private static final long serialVersionUID = 8264676523759784745L;

    private List<String> errors;
    private String protocol;

    private ErrorResponseDto(String code){
        this.errors = new ArrayList<>();
        this.protocol = new UniqueUUID().generate();
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponseDto addError(String error){
        this.errors.add(error);
        this.message = this.errors;
        return this;
    }
}
