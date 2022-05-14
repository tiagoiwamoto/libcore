package br.com.tiagoiwamoto.libcore.model.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        StatusEnum[] statusEnums = StatusEnum.values();
        Arrays.stream(statusEnums).forEach(Assertions::assertNotNull);

    }

}
