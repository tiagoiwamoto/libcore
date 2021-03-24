package br.com.tiagoiwamoto.iwtlibcore.model.enums;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 19/02/2021 - 17:01
*/

public class EnumsTest {

    @Test
    public void testEnums(){
        SexEnum[] sexEnums = SexEnum.values();
        Arrays.stream(sexEnums).forEach(Assert::assertNotNull);

        StatusEnum[] statusEnums = StatusEnum.values();
        Arrays.stream(statusEnums).forEach(Assert::assertNotNull);

    }

}
