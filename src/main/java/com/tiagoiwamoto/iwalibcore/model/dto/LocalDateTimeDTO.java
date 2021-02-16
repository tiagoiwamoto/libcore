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
    private String dateFormated;
    private LocalTime time;
    private String timeFormated;
    private Long timestamp;

    public LocalDateTimeDTO(String formated, LocalDate date, String dateFormated, LocalTime time, String timeFormated, Long timestamp) {
        this.formated = formated;
        this.date = date;
        this.dateFormated = dateFormated;
        this.time = time;
        this.timeFormated = timeFormated;
        this.timestamp = timestamp;
    }

    public String getFormated() {
        return formated;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateFormated() {
        return dateFormated;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getTimeFormated() {
        return timeFormated;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocalDateTimeDTO{");
        sb.append("formated='").append(formated).append('\'');
        sb.append(", date=").append(date);
        sb.append(", dateFormated='").append(dateFormated).append('\'');
        sb.append(", time=").append(time);
        sb.append(", timeFormated='").append(timeFormated).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
