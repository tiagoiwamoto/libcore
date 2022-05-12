package br.com.tiagoiwamoto.libcore.model.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:33
 */

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@ToString
public class LocalDateTimeDto implements Serializable {

    private static final long serialVersionUID = -1958262782708130756L;
    private final String formated;
    private final LocalDate date;
    private final String dateFormated;
    private final LocalTime time;
    private final String timeFormated;
    private final Long timestamp;

    public LocalDateTimeDto(String formated, LocalDate date, String dateFormated, LocalTime time, String timeFormated, Long timestamp) {
        this.formated = formated;
        this.date = date;
        this.dateFormated = dateFormated;
        this.time = time;
        this.timeFormated = timeFormated;
        this.timestamp = timestamp;
    }

}
