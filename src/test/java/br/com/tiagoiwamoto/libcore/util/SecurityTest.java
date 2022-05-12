package br.com.tiagoiwamoto.libcore.util;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 18/02/2021 | 07:42
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecurityTest {

    @Test
    public void testEncryptDecrypt() {
        String originalString = "com.tiagoiwamoto.iwtlibcore";

        String encryptedString = new Security().encrypt(originalString, "secretKey") ;

        Assertions.assertNotNull(new Security().encrypt(originalString, "secretKey"));
        Assertions.assertNotNull(new Security().decrypt(encryptedString, "boooooooooom!!!!"));
    }
}
