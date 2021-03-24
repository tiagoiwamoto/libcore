package br.com.tiagoiwamoto.iwtlibcore.util;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertNotNull(new Ldtu().formated());
        Assert.assertNotNull(new Ldtu().date());
        Assert.assertNotNull(new Ldtu().dateFormated());
        Assert.assertNotNull(new Ldtu().time());
        Assert.assertNotNull(new Ldtu().timeFormated());
        Assert.assertNotNull(new Ldtu().timeFormated());
        Assert.assertNotNull(new Ldtu().withFullFormatPattern("yyyy-MM-dd HHmmss").formated());
        Assert.assertNotNull(new Ldtu().withDateFormatPattern("MM|dd|yyyy").dateFormated());
        Assert.assertNotNull(new Ldtu().withTimeFormatPattern("hh|mm|ss").timeFormated());
        Assert.assertNotNull(new Ldtu().withTimeZone("America/Sao_Paulo").timeFormated());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).formated());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).date());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).dateFormated());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).time());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).timeFormated());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withFullFormatPattern("yyyy-MM-dd HHmmss").formated());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withDateFormatPattern("MM|dd|yyyy").dateFormated());
        Assert.assertNotNull(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withTimeFormatPattern("hh|mm|ss").timeFormated());
    }

}
