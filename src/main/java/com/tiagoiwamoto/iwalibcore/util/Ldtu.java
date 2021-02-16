package com.tiagoiwamoto.iwalibcore.util;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:27
 */

import com.tiagoiwamoto.iwalibcore.model.dto.LocalDateTimeDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ldtu {

    private LocalDateTime localDateTime;
    private LocalDateTimeDTO localDateTimeDTO;
    private String fullPattern;
    private String datePattern;
    private String timePattern;
    private String zoneId;

    public Ldtu() {
        this.localDateTime = LocalDateTime.now();
        this.localDateTimeDTO = clock();
    }

    public Ldtu(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        this.localDateTimeDTO = clock();
    }

    public Ldtu withFullFormatPattern(String pattern){
        this.fullPattern = pattern;
        this.localDateTimeDTO = clock();
        return this;
    }

    public Ldtu withDateFormatPattern(String pattern){
        this.datePattern = pattern;
        this.localDateTimeDTO = clock();
        return this;
    }

    public Ldtu withTimeFormatPattern(String pattern){
        this.timePattern = pattern;
        this.localDateTimeDTO = clock();
        return this;
    }

    public Ldtu withTimeZone(String pattern){
        this.zoneId = pattern;
        this.localDateTimeDTO = clock();
        return this;
    }

    private LocalDateTimeDTO clock(){
        DateTimeFormatter fullFormat = DateTimeFormatter.ofPattern(this.fullPattern == null ? "dd/MM/yyyy HH:mm:ss" : this.fullPattern);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(this.datePattern == null ? "dd/MM/yyyy" : this.datePattern);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern(this.timePattern == null ? "HH:mm:ss" : this.timePattern);
        LocalDate localDate = this.localDateTime.toLocalDate();
        LocalTime localTime = this.localDateTime.toLocalTime();
        ZonedDateTime zdt = this.localDateTime.atZone(ZoneId.of(this.zoneId == null ? "America/Sao_Paulo" : this.zoneId));
        long timeStampMillis = zdt.toInstant().toEpochMilli();
        return new LocalDateTimeDTO(
                fullFormat.format(this.localDateTime), localDate, dateFormat.format(localDate),
                localTime, timeFormat.format(localTime), timeStampMillis);
    }

    public String formated(){
        return localDateTimeDTO.getFormated();
    }

    public LocalDate date(){
        return localDateTimeDTO.getDate();
    }

    public String dateFormated(){
        return localDateTimeDTO.getDateFormated();
    }

    public LocalTime time(){
        return localDateTimeDTO.getTime();
    }

    public String timeFormated(){
        return localDateTimeDTO.getTimeFormated();
    }
}
