package br.com.tiagoiwamoto.libcore.util;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 18/02/2021 | 07:45
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueUUIDTest {

    @Test
    public void generate() {
        Assertions.assertNotNull(new UniqueUUID().generate());
    }
}
