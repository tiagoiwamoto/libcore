package com.tiagoiwamoto.iwalibcore.util;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:27
 */

import com.tiagoiwamoto.iwalibcore.model.dto.LocalDateTimeDTO;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocaDateTimeUtils {

    private final LocalDateTime localDateTime;

    public LocaDateTimeUtils() {
        this.localDateTime = LocalDateTime.now();
    }

    public LocaDateTimeUtils(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTimeDTO clock(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDate localDate = this.localDateTime.toLocalDate();
        LocalTime localTime = this.localDateTime.toLocalTime();
        ZonedDateTime zdt = this.localDateTime.atZone(ZoneId.of("America/Sao_Paulo"));
        long timeStampMillis = zdt.toInstant().toEpochMilli();
        return new LocalDateTimeDTO(dtf.format(this.localDateTime), localDate, localTime, timeStampMillis);
    }
}
