package br.com.tiagoiwamoto.libcore.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 18/02/2021 | 07:32
 */

public class LdtuTest {
    
    @Test
    public void testLdtu(){
        Assertions.assertNotNull(new Ldtu().formated());
        Assertions.assertNotNull(new Ldtu().date());
        Assertions.assertNotNull(new Ldtu().dateFormated());
        Assertions.assertNotNull(new Ldtu().time());
        Assertions.assertNotNull(new Ldtu().timeFormated());
        Assertions.assertNotNull(new Ldtu().timeFormated());
        Assertions.assertNotNull(new Ldtu().withFullFormatPattern("yyyy-MM-dd HHmmss").formated());
        Assertions.assertNotNull(new Ldtu().withDateFormatPattern("MM|dd|yyyy").dateFormated());
        Assertions.assertNotNull(new Ldtu().withTimeFormatPattern("hh|mm|ss").timeFormated());
        Assertions.assertNotNull(new Ldtu().withTimeZone("America/Sao_Paulo").timeFormated());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).formated());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).date());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).dateFormated());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).time());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).timeFormated());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withFullFormatPattern("yyyy-MM-dd HHmmss").formated());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withDateFormatPattern("MM|dd|yyyy").dateFormated());
        Assertions.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withTimeFormatPattern("hh|mm|ss").timeFormated());
    }

}
