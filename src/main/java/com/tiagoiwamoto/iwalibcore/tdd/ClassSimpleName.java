package com.tiagoiwamoto.iwalibcore.tdd;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 16/02/2021 | 20:11
 */

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ClassSimpleName {

    public static void main(String[] args) {
        System.out.println(String.class.getSimpleName());
        System.out.println(Integer.class.getSimpleName());
        System.out.println(Long.class.getSimpleName());
        System.out.println(Float.class.getSimpleName());
        System.out.println(Boolean.class.getSimpleName());
        System.out.println(BigDecimal.class.getSimpleName());
        System.out.println(Timestamp.class.getSimpleName());
        System.out.println(Date.class.getSimpleName());
        System.out.println(Time.class.getSimpleName());
    }

}
