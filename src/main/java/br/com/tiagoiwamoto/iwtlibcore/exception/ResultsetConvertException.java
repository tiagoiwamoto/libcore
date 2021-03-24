package br.com.tiagoiwamoto.iwtlibcore.exception;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 20/03/2021 | 17:54
 */

public class ResultsetConvertException extends RuntimeException{

    public ResultsetConvertException() {
    }

    public ResultsetConvertException(String message) {
        super(message);
    }

    public ResultsetConvertException(String message, Throwable cause) {
        super(message, cause);
    }
}
