package com.tiagoiwamoto.iwtlibcore.tdd;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:50
 */

import com.tiagoiwamoto.iwtlibcore.util.Ldtu;

import java.time.LocalDateTime;
import java.time.Month;

public class ClockTDD {

    public static void main(String[] args) {
//        System.out.println(new Ldtu().formated());
//        System.out.println(new Ldtu().date());
//        System.out.println(new Ldtu().dateFormated());
//        System.out.println(new Ldtu().time());
//        System.out.println(new Ldtu().timeFormated());
//        System.out.println(new Ldtu().withFullFormatPattern("yyyy-MM-dd HHmmss").formated());
//        System.out.println(new Ldtu().withDateFormatPattern("MM|dd|yyyy").dateFormated());
//        System.out.println(new Ldtu().withTimeFormatPattern("hh|mm|ss").timeFormated());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).formated());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).date());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).dateFormated());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).time());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).timeFormated());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withFullFormatPattern("yyyy-MM-dd HHmmss").formated());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withDateFormatPattern("MM|dd|yyyy").dateFormated());
        System.out.println(new Ldtu(LocalDateTime.of(2020, Month.DECEMBER, 30, 10, 30, 55)).withTimeFormatPattern("hh|mm|ss").timeFormated());
    }

}
