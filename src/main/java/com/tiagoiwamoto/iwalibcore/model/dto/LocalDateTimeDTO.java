package com.tiagoiwamoto.iwalibcore.model.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:33
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateTimeDTO {

    private String formated;
    private LocalDate date;
    private LocalTime time;
    private Long timestamp;

    public LocalDateTimeDTO(String formated, LocalDate date, LocalTime time, Long timestamp) {
        this.formated = formated;
        this.date = date;
        this.time = time;
        this.timestamp = timestamp;
    }

    public String getFormated() {
        return formated;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocalDateTimeDTO{");
        sb.append("formated='").append(formated).append('\'');
        sb.append(", date=").append(date);
        sb.append(", time='").append(time).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
