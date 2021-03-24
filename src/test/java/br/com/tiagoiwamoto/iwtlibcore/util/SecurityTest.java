package br.com.tiagoiwamoto.iwtlibcore.util;

import org.junit.Assert;
import org.junit.Test;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 18/02/2021 | 07:42
 */

public class SecurityTest {

    @Test
    public void testEncryptDecrypt() {
        String originalString = "com.tiagoiwamoto.iwtlibcore";

        String encryptedString = new Security().encrypt(originalString, "secretKey") ;

        Assert.assertNotNull(new Security().encrypt(originalString, "secretKey"));
        Assert.assertNotNull(new Security().decrypt(encryptedString, "boooooooooom!!!!"));
    }
}
